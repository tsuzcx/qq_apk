package com.tencent.mobileqq.emosm.favroaming;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog.IFileSaveCancelInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class EmoBatchAddedHandler
  implements Handler.Callback, IEmoBatchAddedHandler
{
  Handler a;
  IChatHistoryEmotionBaseFragment b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  boolean i = false;
  BaseQQAppInterface j;
  FileSaveDialog k;
  public boolean l;
  FileSaveDialog.IFileSaveCancelInterface m;
  public int n;
  public Map<String, Integer> o;
  int p;
  
  public EmoBatchAddedHandler(IChatHistoryEmotionBaseFragment paramIChatHistoryEmotionBaseFragment, BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.b = paramIChatHistoryEmotionBaseFragment;
    this.a = new Handler(Looper.getMainLooper(), this);
    this.j = paramBaseQQAppInterface;
    this.m = new EmoBatchAddedHandler.1(this);
    this.o = new HashMap();
  }
  
  private void c()
  {
    if (!this.i)
    {
      this.i = true;
      Object localObject = this.k;
      if ((localObject != null) && (((FileSaveDialog)localObject).isShowing()))
      {
        this.k.dismiss();
        this.k = null;
      }
      localObject = this.j.getHandler(((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityClass());
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
      }
      localObject = this.b;
      if (localObject != null)
      {
        ((IChatHistoryEmotionBaseFragment)localObject).changeToUnSelected();
        if (this.e > 0)
        {
          QQToast.makeText(MobileQQ.getContext(), 1, MobileQQ.getContext().getString(2131888276), 1).show();
        }
        else if (this.g == this.c)
        {
          QQToast.makeText(MobileQQ.getContext(), 1, MobileQQ.getContext().getString(2131888869), 1).show();
        }
        else
        {
          int i1 = this.f;
          if (i1 == 0) {
            QQToast.makeText(MobileQQ.getContext(), 1, MobileQQ.getContext().getString(2131888867), 1).show();
          } else if (i1 > 0) {
            if (this.h > 0) {
              QQToast.makeText(MobileQQ.getContext(), 0, MobileQQ.getContext().getString(2131888868), 1).show();
            } else {
              QQToast.makeText(MobileQQ.getContext(), 2, MobileQQ.getContext().getString(2131888870), 1).show();
            }
          }
        }
      }
      StickerRecManagerImpl.get(this.j).updateKeywordForFavEmotion();
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
    }
  }
  
  public int a()
  {
    return this.n;
  }
  
  public int a(Integer paramInteger)
  {
    return this.p + paramInteger.intValue();
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    this.d = paramInt;
    paramInt = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = false;
    this.l = false;
    this.o.clear();
    this.p = 1;
    this.n = 0;
    List localList = ((IFavroamingDBManagerService)this.j.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
    if (localList != null) {
      while (paramInt < localList.size())
      {
        int i1 = ((CustomEmotionData)localList.get(paramInt)).emoId;
        if (this.p < i1) {
          this.p = i1;
        }
        if ((TextUtils.isEmpty(((CustomEmotionData)localList.get(paramInt)).RomaingType)) || (!"needDel".equals(((CustomEmotionData)localList.get(paramInt)).RomaingType))) {
          this.n += 1;
        }
        paramInt += 1;
      }
    }
    this.p += 1;
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    this.o.put(paramString, Integer.valueOf(this.p + paramInteger.intValue()));
  }
  
  public boolean a(String paramString)
  {
    return this.o.containsKey(paramString);
  }
  
  public int b(String paramString)
  {
    Map localMap = this.o;
    if (localMap != null) {
      return ((Integer)localMap.get(paramString)).intValue();
    }
    return -1;
  }
  
  public void b()
  {
    this.k = new FileSaveDialog(this.b.getBaseActivity());
    this.k.a(this.m);
    this.k.show();
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (this.a != null) {
        this.a.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.l) {
      return false;
    }
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 == 100)
            {
              b();
              return true;
            }
          }
          else {
            this.f += 1;
          }
        }
        else {
          this.h += 1;
        }
      }
      else {
        this.g += 1;
      }
    }
    else {
      this.e += 1;
    }
    this.d -= 1;
    Object localObject = this.k;
    if (localObject != null)
    {
      i1 = this.c;
      ((FileSaveDialog)localObject).a((i1 - this.d) * 100 / i1);
    }
    if ((this.d <= 0) || (paramMessage.what == 1)) {
      c();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ahandleMessage =");
    ((StringBuilder)localObject).append(paramMessage.what);
    ((StringBuilder)localObject).append(",mNeedAddCount:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(",mTotalCount:");
    ((StringBuilder)localObject).append(this.c);
    QLog.d("EmoBatchAdded", 2, ((StringBuilder)localObject).toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandler
 * JD-Core Version:    0.7.0.1
 */