package com.tencent.mobileqq.guild.chatpie.manager;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.magicface.drawable.IMessageHandler;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.drawable.PngPlayParam;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class GuildPngFrameManager
  implements IMessageHandler, Manager
{
  QQAppInterface a;
  ConcurrentHashMap<String, PngPlayParam> b;
  HashMap<Long, Boolean> c;
  PngFrameUtil d;
  Handler e;
  DownloaderInterface f;
  
  @SuppressLint({"UseSparseArrays"})
  public GuildPngFrameManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【Constructor】  ");
    }
    this.a = paramQQAppInterface;
    this.e = a(this);
    this.d = new PngFrameUtil();
    this.b = new ConcurrentHashMap();
    this.c = new HashMap();
    this.f = ((DownloaderFactory)this.a.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public static Handler a(IMessageHandler paramIMessageHandler)
  {
    return new GuildPngFrameManager.InnerHandler(paramIMessageHandler);
  }
  
  PngFrameDrawable a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("func getPngFrameDrawable begins,epId:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",pos:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",showProcess:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("PngFrameManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("PngFrameManager_");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt);
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = a(paramString);
    paramString = null;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = GlobalImageCache.a.get(str);
    if ((localObject2 instanceof PngFrameDrawable)) {
      paramString = (PngFrameDrawable)localObject2;
    }
    if ((paramString != null) && (!paramBoolean) && (paramString.a()))
    {
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("func getPngFrameDrawable, drawable exists in map,pos:");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("PngFrameManager", 2, ((StringBuilder)localObject1).toString());
        localObject1 = paramString;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
      }
      ((PngPlayParam)localObject1).g = paramBoolean;
      localObject1 = new PngFrameDrawable((PngPlayParam)localObject1, this.a.getApplication().getResources());
      GlobalImageCache.a.put(str, localObject1);
      ((PngFrameDrawable)localObject1).a(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func getPngFrameDrawable ends");
    }
    return localObject1;
  }
  
  public PngPlayParam a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = (PngPlayParam)((ConcurrentHashMap)localObject).get(paramString);
        if (localObject != null) {
          return localObject;
        }
        return b(paramString);
      }
    }
    return null;
  }
  
  void a(GuildPngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    if ((paramRandomDrawableParam != null) && (paramRandomDrawableParam.c != null) && (paramRandomDrawableParam.e == paramRandomDrawableParam.c.t) && (paramRandomDrawableParam.g != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func onTypeGif, 【rsyType is GIF, use the OLD way to show.】");
      }
      paramRandomDrawableParam.g.a(true);
    }
  }
  
  @SuppressLint({"InlinedApi"})
  void a(GuildMarketFaceItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (200 * j + 160) / 320;
    j = (200 * j + 160) / 320;
    if (paramBoolean)
    {
      paramHolder.h.setLayoutParams(new FrameLayout.LayoutParams(i, j));
      return;
    }
    paramHolder = (RelativeLayout.LayoutParams)paramHolder.h.getLayoutParams();
    paramHolder.width = i;
    paramHolder.height = j;
  }
  
  public void a(String paramString, GuildMarketFaceItemBuilder.Holder paramHolder, long paramLong, boolean paramBoolean1, boolean paramBoolean2, GuildPngFrameManager.IMagicCallback paramIMagicCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramHolder != null))
    {
      a(paramHolder, paramBoolean2);
      GuildPngFrameManager.RandomDrawableParam localRandomDrawableParam = new GuildPngFrameManager.RandomDrawableParam(this);
      localRandomDrawableParam.g = paramIMagicCallback;
      localRandomDrawableParam.d = paramHolder.a.getEmoticon().epId;
      localRandomDrawableParam.c = paramHolder;
      localRandomDrawableParam.e = paramLong;
      localRandomDrawableParam.f = paramBoolean1;
      localRandomDrawableParam.b = PngFrameUtil.c(paramString);
      if (localRandomDrawableParam.c.o == null) {
        localRandomDrawableParam.c.o = new ProgressBar(BaseApplicationImpl.getContext());
      }
      if (localRandomDrawableParam.c.c == null) {
        localRandomDrawableParam.c.c = new ImageView(BaseApplicationImpl.getContext());
      }
      int i = PngFrameUtil.b(paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("func setMagicDrawable, 【rscType】:");
        paramString.append(i);
        paramString.append(",【randomValue】:");
        paramString.append(localRandomDrawableParam.b);
        paramString.append(",【showProcess】:");
        paramString.append(paramBoolean1);
        paramString.append(",tag:");
        paramString.append(paramLong);
        QLog.d("PngFrameManager", 2, paramString.toString());
      }
      paramHolder.u = i;
      if (i != -1)
      {
        if (i != 0)
        {
          if (i == 1) {
            c(localRandomDrawableParam);
          }
        }
        else {
          a(localRandomDrawableParam);
        }
      }
      else {
        b(localRandomDrawableParam);
      }
      if (localRandomDrawableParam.c.n == null) {
        return;
      }
      paramString = this.e;
      if (paramString == null) {
        return;
      }
      paramString.postDelayed(new GuildPngFrameManager.1(this, localRandomDrawableParam), 1000L);
      return;
    }
    if (paramIMagicCallback != null) {
      paramIMagicCallback.a(true);
    }
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      if (this.c == null) {
        this.c = new HashMap();
      }
      if (((Boolean)this.c.get(Long.valueOf(paramLong)) == null) && (this.e != null))
      {
        this.e.postDelayed(new GuildPngFrameManager.5(this, paramLong), 500L);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public PngPlayParam b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    PngPlayParam localPngPlayParam = this.d.a(paramString);
    if (localPngPlayParam != null) {
      this.b.put(paramString, localPngPlayParam);
    }
    return localPngPlayParam;
  }
  
  void b(GuildPngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    paramRandomDrawableParam.c.o.setVisibility(0);
    paramRandomDrawableParam.c.h.setImageResource(2130848999);
    ThreadManager.post(new GuildPngFrameManager.2(this, paramRandomDrawableParam), 5, null, true);
  }
  
  void c(GuildPngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func onTypePngZip begins, param:");
      localStringBuilder.append(paramRandomDrawableParam);
      QLog.d("PngFrameManager", 2, localStringBuilder.toString());
    }
    if (new File(EmotionPanelConstans.pngFramePath.replace("[epId]", paramRandomDrawableParam.d)).exists())
    {
      f(paramRandomDrawableParam);
      return;
    }
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramRandomDrawableParam);
      return;
    }
    paramRandomDrawableParam.c.o.setVisibility(0);
    paramRandomDrawableParam.c.h.setImageResource(2130848999);
    e(paramRandomDrawableParam);
  }
  
  void d(GuildPngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    String str = EmotionPanelConstans.emoticonAIOPreviewPath.replace("[epId]", paramRandomDrawableParam.d).replace("[eId]", paramRandomDrawableParam.c.a.getEmoticon().eId);
    Bitmap localBitmap = (Bitmap)GlobalImageCache.a.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showAIOPreview, 【aio preview】, exist in Cache.");
      }
      paramRandomDrawableParam.h = localBitmap;
      try
      {
        if (this.e != null) {
          this.e.obtainMessage(227, paramRandomDrawableParam).sendToTarget();
        }
        return;
      }
      finally {}
    }
    paramRandomDrawableParam.c.o.setVisibility(0);
    paramRandomDrawableParam.c.h.setImageResource(2130848999);
    ThreadManager.post(new GuildPngFrameManager.3(this, str, paramRandomDrawableParam), 5, null, true);
  }
  
  void e(GuildPngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    ThreadManager.post(new GuildPngFrameManager.4(this, paramRandomDrawableParam), 5, null, true);
  }
  
  void f(GuildPngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    Object localObject = a(paramRandomDrawableParam.d);
    if (localObject != null)
    {
      if (!((PngPlayParam)localObject).a()) {
        return;
      }
      localObject = a(paramRandomDrawableParam.d, paramRandomDrawableParam.b, paramRandomDrawableParam.f);
      if ((paramRandomDrawableParam.c != null) && (paramRandomDrawableParam.c.t == paramRandomDrawableParam.e))
      {
        if (localObject != null)
        {
          paramRandomDrawableParam.c.o.setVisibility(8);
          paramRandomDrawableParam.c.h.setImageDrawable((Drawable)localObject);
          return;
        }
        try
        {
          if (this.e != null) {
            this.e.obtainMessage(226, paramRandomDrawableParam).sendToTarget();
          }
          return;
        }
        finally {}
      }
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showDrawable ends, 【holder not Exists!】");
      }
    }
  }
  
  public void handleMsg(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 227: 
      paramMessage = (GuildPngFrameManager.RandomDrawableParam)paramMessage.obj;
      if (paramMessage.e != paramMessage.c.t) {
        return;
      }
      paramMessage.c.o.setVisibility(8);
      paramMessage.c.c.setVisibility(0);
      paramMessage.c.h.setImageBitmap((Bitmap)paramMessage.h);
      return;
    case 226: 
      paramMessage = (GuildPngFrameManager.RandomDrawableParam)paramMessage.obj;
      paramMessage.c.o.setVisibility(8);
      paramMessage.c.h.setImageResource(2130849000);
      return;
    case 225: 
      paramMessage = (GuildPngFrameManager.RandomDrawableParam)paramMessage.obj;
      paramMessage.c.c.setVisibility(8);
      f(paramMessage);
      return;
    }
    paramMessage = (GuildPngFrameManager.RandomDrawableParam)paramMessage.obj;
    paramMessage.c.u = paramMessage.a;
    if (paramMessage.a == 0)
    {
      a(paramMessage);
      return;
    }
    if (paramMessage.a == 1) {
      c(paramMessage);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【onDestroy】  ");
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      ((ConcurrentHashMap)localObject).clear();
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.c = null;
    }
    this.e = null;
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.manager.GuildPngFrameManager
 * JD-Core Version:    0.7.0.1
 */