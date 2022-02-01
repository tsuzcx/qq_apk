package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.reward.aidl.RIJAidlServer;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoMetaInfo;
import com.tencent.mobileqq.kandian.biz.ugc.video.transfer.KingsMomentVideoDeliverController;
import com.tencent.mobileqq.kandian.biz.ugc.video.transfer.NormalVideoDeliverController;
import com.tencent.mobileqq.kandian.biz.video.constants.IKandianVideoUploadServiceConst;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class KandianVideoUploadService
  extends Service
  implements Handler.Callback, KandianVideoUploadController.DeliverVideoTaskListener, IKandianVideoUploadServiceConst
{
  private static Map<String, WeakReference<KandianVideoUploadController>> c = new HashMap();
  private static WeakReference<KandianVideoUploadService.ICallBack> d;
  private static final String[] e = { "com.tencent.biz.pubaccount.readinjoy" };
  private static final String[] f = { "kandian", "readinjoy", "post.mp.qq.com " };
  private final MqqHandler a = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private boolean b = false;
  private RIJAidlServer g = new RIJAidlServer();
  
  public static int a()
  {
    return KanDianVideoUploadUtils.a().size();
  }
  
  public static void a(Bundle paramBundle, KandianVideoUploadService.ICallBack paramICallBack)
  {
    Object localObject = paramBundle.getString("mTaskID");
    localObject = (WeakReference)c.get(localObject);
    if (localObject != null) {
      localObject = (KandianVideoUploadController)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      paramICallBack.a(paramBundle, 200, ((KandianVideoUploadController)localObject).h);
      return;
    }
    if (c.size() < 2)
    {
      paramICallBack.a(paramBundle, 202, 0.0F);
      return;
    }
    paramICallBack.a(paramBundle, 201, 0.0F);
  }
  
  public static void a(KandianVideoUploadService.ICallBack paramICallBack)
  {
    if (paramICallBack != null) {
      d = new WeakReference(paramICallBack);
    }
  }
  
  private void a(String paramString)
  {
    QLog.d("KandianVideoUploadService", 1, "removeTask!");
    KandianVideoUploadController localKandianVideoUploadController = (KandianVideoUploadController)((WeakReference)c.get(paramString)).get();
    if (localKandianVideoUploadController != null) {
      localKandianVideoUploadController.b();
    }
    c.remove(paramString);
    if (c.size() == 0) {
      stopSelf();
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0.0F);
  }
  
  private void a(String paramString, int paramInt, float paramFloat)
  {
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("mTaskID", paramString);
    localMessage.what = paramInt;
    localMessage.obj = Float.valueOf(paramFloat);
    localMessage.setData(localBundle);
    this.a.sendMessage(localMessage);
  }
  
  private boolean a(String[] paramArrayOfString, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (paramString.contains(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private KandianVideoUploadService.ICallBack b()
  {
    WeakReference localWeakReference = d;
    if (localWeakReference != null) {
      return (KandianVideoUploadService.ICallBack)localWeakReference.get();
    }
    return null;
  }
  
  private boolean c()
  {
    Object localObject = BaseActivity.sTopActivity;
    boolean bool;
    if (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab())
    {
      bool = true;
    }
    else if (localObject == null)
    {
      bool = a(f, d());
    }
    else
    {
      localObject = localObject.toString();
      bool = a(e, (String)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isInkandian:");
    ((StringBuilder)localObject).append(bool);
    QLog.d("KandianVideoUploadService", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private String d()
  {
    return RIJSPUtils.a(ReadInJoyUtils.b(), false, true).getString("mLoadingUrl", "");
  }
  
  protected void a(int paramInt, CharSequence paramCharSequence)
  {
    if (c()) {
      QQToast.makeText(getBaseContext(), paramInt, paramCharSequence, 0).show(getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  protected void a(Intent paramIntent, String paramString)
  {
    if (c.size() >= 2)
    {
      paramIntent = c.values().iterator();
      while (paramIntent.hasNext())
      {
        paramString = (KandianVideoUploadController)((WeakReference)paramIntent.next()).get();
        QLog.d("KandianVideoUploadService", 1, "startTask");
      }
      return;
    }
    String str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = String.valueOf(System.currentTimeMillis() + (Math.random() * 10000.0D));
    }
    paramString = paramIntent.getStringExtra("arg_video_path");
    boolean bool1 = false;
    boolean bool2 = paramIntent.getBooleanExtra("arg_is_from_wang_zhe", false);
    String str2 = paramIntent.getStringExtra("arg_video_cover");
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      if ((!bool2) && ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())))
      {
        QLog.d("KandianVideoUploadService", 1, "onDeliver video not exist!");
        paramString = b();
        if (paramString != null)
        {
          paramIntent = paramIntent.getExtras();
          if (paramIntent != null) {
            paramString.a(paramIntent, getString(2131916627));
          }
        }
        return;
      }
      paramIntent.putExtra("mTaskID", str1);
      paramString = c.keySet().iterator();
      while (paramString.hasNext()) {
        bool1 = ((String)paramString.next()).equalsIgnoreCase(str1);
      }
      if (bool1)
      {
        QLog.d("KandianVideoUploadService", 1, "has same task!");
        return;
      }
      if (bool2) {
        paramIntent = new KingsMomentVideoDeliverController(this, this, paramIntent);
      } else {
        paramIntent = new NormalVideoDeliverController(this, this, paramIntent);
      }
      paramString = new WeakReference(paramIntent);
      c.put(str1, paramString);
      paramIntent.a();
      return;
    }
    QLog.d("KandianVideoUploadService", 1, "coverParh not exist!");
  }
  
  public void a(String paramString, float paramFloat)
  {
    a(paramString, 108, paramFloat);
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    paramString2 = (KandianVideoUploadController)((WeakReference)c.get(paramString1)).get();
    if ((paramString2 instanceof NormalVideoDeliverController)) {
      paramString2 = ((NormalVideoDeliverController)paramString2).o;
    } else {
      paramString2 = null;
    }
    paramString3 = b();
    if (paramInt1 != 0)
    {
      if ((paramString3 != null) && (paramString2 != null)) {
        paramString3.a(paramString2, paramString4);
      }
      a(1, paramString4);
    }
    else
    {
      if (paramString3 != null) {
        paramString3.a(paramString1);
      }
      a(2, getString(2131915567));
    }
    a(paramString1);
  }
  
  public void a(String paramString, int paramInt, VideoMetaInfo paramVideoMetaInfo)
  {
    int i = 1003;
    switch (paramInt)
    {
    default: 
      break;
    case 13: 
      a(paramString, 105);
      break;
    case 11: 
      a(paramString, 104);
      break;
    case 10: 
      a(paramString, 105);
      break;
    case 9: 
      a(paramString, 105);
      break;
    case 8: 
      a(paramString, 100);
      i = 1002;
      break;
    case 7: 
      a(paramString, 104);
      break;
    case 6: 
      a(paramString, 105);
      break;
    case 5: 
      a(paramString, 105);
      i = 1004;
      break;
    case 4: 
      a(paramString, 102);
      break;
    case 3: 
      a(paramString, 100);
      break;
    case 2: 
      a(paramString, 107);
      break;
    case 1: 
      a(paramString, 106);
      i = 1001;
      break;
    }
    i = 0;
    paramVideoMetaInfo = new StringBuilder();
    paramVideoMetaInfo.append("deliver over!");
    paramVideoMetaInfo.append(paramInt);
    QLog.d("KandianVideoUploadService", 1, paramVideoMetaInfo.toString());
    if (paramInt != 0)
    {
      paramString = (KandianVideoUploadController)((WeakReference)c.get(paramString)).get();
      if (paramString != null) {
        paramString.a(i);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = String.valueOf(paramMessage.getData().get("mTaskID"));
    int k = paramMessage.what;
    int j = 0;
    int i = -1;
    float f1 = 0.0F;
    if (k == 100)
    {
      paramMessage = getString(2131915555);
      i = 100;
    }
    else if (paramMessage.what == 101)
    {
      paramMessage = getString(2131916627);
      i = 101;
    }
    else if (paramMessage.what == 102)
    {
      paramMessage = getString(2131915557);
      i = 102;
    }
    else if (paramMessage.what == 103)
    {
      paramMessage = "";
      i = 103;
    }
    else if (paramMessage.what == 104)
    {
      paramMessage = getString(2131915562);
      i = 104;
    }
    else if (paramMessage.what == 105)
    {
      paramMessage = getString(2131915556);
      i = 105;
    }
    else if (paramMessage.what == 106)
    {
      paramMessage = getString(2131915563);
      i = 106;
    }
    else if (paramMessage.what == 107)
    {
      if (this.b) {
        paramMessage = getString(2131915566);
      } else {
        paramMessage = getString(2131915565);
      }
      i = 107;
    }
    else if (paramMessage.what == 108)
    {
      f1 = ((Float)paramMessage.obj).floatValue();
      paramMessage = "";
      j = 1;
    }
    else
    {
      paramMessage = "";
    }
    KandianVideoUploadController localKandianVideoUploadController = (KandianVideoUploadController)((WeakReference)c.get(localObject)).get();
    if (localKandianVideoUploadController != null)
    {
      Bundle localBundle = null;
      if ((localKandianVideoUploadController instanceof NormalVideoDeliverController)) {
        localBundle = ((NormalVideoDeliverController)localKandianVideoUploadController).o;
      } else if ((localKandianVideoUploadController instanceof KingsMomentVideoDeliverController)) {
        localBundle = ((KingsMomentVideoDeliverController)localKandianVideoUploadController).o;
      }
      if (j == 0) {
        a((String)localObject);
      }
      localObject = b();
      if (j != 0)
      {
        if (j != 1) {
          return true;
        }
        if ((localObject != null) && (localBundle != null))
        {
          ((KandianVideoUploadService.ICallBack)localObject).a(localBundle, f1);
          return true;
        }
      }
      else
      {
        a(1, paramMessage);
        if ((localObject != null) && (localBundle != null)) {
          ((KandianVideoUploadService.ICallBack)localObject).a(localBundle, paramMessage);
        }
        this.a.removeMessages(i);
      }
    }
    return true;
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return this.g;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      Object localObject2 = paramIntent.getStringExtra("mTaskID");
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("receive task  taskID :");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" now taskMap:");
      ((StringBuilder)localObject1).append(c.size());
      QLog.d("KandianVideoUploadService", 1, ((StringBuilder)localObject1).toString());
      Object localObject3 = (WeakReference)c.get(localObject2);
      localObject1 = null;
      if (localObject3 != null) {
        localObject1 = (KandianVideoUploadController)((WeakReference)localObject3).get();
      }
      if (localObject1 != null)
      {
        localObject2 = b();
        if (localObject2 != null)
        {
          localObject3 = paramIntent.getExtras();
          if (localObject3 != null) {
            ((KandianVideoUploadService.ICallBack)localObject2).a((Bundle)localObject3, ((KandianVideoUploadController)localObject1).h);
          }
        }
      }
      else
      {
        a(paramIntent, (String)localObject2);
      }
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadService
 * JD-Core Version:    0.7.0.1
 */