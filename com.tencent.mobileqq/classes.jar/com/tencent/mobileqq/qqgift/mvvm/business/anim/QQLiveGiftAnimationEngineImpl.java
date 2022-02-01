package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.callback.IQQGiftEngineAnimationListener;
import com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager;
import com.tencent.mobileqq.qqgift.mvvm.business.banner.GiftBannerContainer;
import com.tencent.mobileqq.qqgift.mvvm.business.banner.GiftBannerContainerListener;
import com.tencent.mobileqq.qqgift.utils.GiftAnimDataComparator;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class QQLiveGiftAnimationEngineImpl
  extends BaseGiftAnimationEngine
  implements IQQGiftEngineAnimationListener, GiftBannerContainerListener
{
  public static LinkedHashMap<String, GiftAnimData> h = new QQLiveGiftAnimationEngineImpl.1();
  private final Map<String, GiftAnimData> i = new HashMap();
  private final Vector<GiftAnimData> j = new Vector();
  private final Vector<GiftAnimData> k = new Vector();
  private GiftAnimData l;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private GiftBannerContainer p;
  private int q = 0;
  private final GiftAnimDataComparator r = new GiftAnimDataComparator();
  
  public QQLiveGiftAnimationEngineImpl(Context paramContext, IQQGiftSDK paramIQQGiftSDK)
  {
    super(paramContext, paramIQQGiftSDK);
  }
  
  private void a(GiftAnimData paramGiftAnimData, int paramInt, Vector<GiftAnimData> paramVector)
  {
    if ((paramInt >= 0) && (paramInt <= paramVector.size()))
    {
      paramVector.add(paramInt, paramGiftAnimData);
      return;
    }
    paramVector.add(paramGiftAnimData);
  }
  
  private void c(GiftAnimData paramGiftAnimData, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("try to addData dataType:");
    ((StringBuilder)localObject).append(j(paramGiftAnimData));
    QLog.i("QQLiveGiftAnimationEngineImpl", 1, ((StringBuilder)localObject).toString());
    if (h(paramGiftAnimData))
    {
      localObject = i(paramGiftAnimData);
      if (((String)localObject).equals(i(this.l))) {
        if (paramGiftAnimData.o > this.l.o)
        {
          if (this.p.a(paramGiftAnimData.o))
          {
            QLog.i("QQLiveGiftAnimationEngineImpl", 1, "try to addData but just update playing num");
            return;
          }
          QLog.i("QQLiveGiftAnimationEngineImpl", 1, "try to addData and update playing num failed");
        }
        else
        {
          QLog.i("QQLiveGiftAnimationEngineImpl", 1, "try to addData but playingNum is big");
          return;
        }
      }
      GiftAnimData localGiftAnimData = (GiftAnimData)this.i.get(localObject);
      if (localGiftAnimData != null)
      {
        localGiftAnimData.o = Math.max(paramGiftAnimData.o, localGiftAnimData.o);
        QLog.i("QQLiveGiftAnimationEngineImpl", 1, "try to addData but just update waiting num");
        return;
      }
      localGiftAnimData = (GiftAnimData)h.get(localObject);
      if (localGiftAnimData != null)
      {
        if (localGiftAnimData.o >= paramGiftAnimData.o)
        {
          QLog.i("QQLiveGiftAnimationEngineImpl", 1, "try to addData but complete is big");
          return;
        }
        paramGiftAnimData.p = (localGiftAnimData.o + 1);
        this.i.put(localObject, paramGiftAnimData);
        a(paramGiftAnimData, paramInt, this.j);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addData to high priority and origNum:");
        ((StringBuilder)localObject).append(paramGiftAnimData.p);
        QLog.i("QQLiveGiftAnimationEngineImpl", 1, ((StringBuilder)localObject).toString());
        return;
      }
      this.i.put(localObject, paramGiftAnimData);
    }
    if (g(paramGiftAnimData))
    {
      QLog.i("QQLiveGiftAnimationEngineImpl", 1, "addData to high queue");
      a(paramGiftAnimData, paramInt, this.j);
      Collections.sort(this.j, this.r);
    }
    else
    {
      QLog.i("QQLiveGiftAnimationEngineImpl", 1, "addData to normal queue");
      a(paramGiftAnimData, paramInt, this.k);
    }
    if (f(paramGiftAnimData)) {
      k();
    }
  }
  
  private void d(GiftAnimData paramGiftAnimData)
  {
    if (paramGiftAnimData != this.l)
    {
      QLog.e("QQLiveGiftAnimationEngineImpl", 1, "checkDismissBanner but data not match");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkNeedDismissBanner ");
      localStringBuilder.append(this.n);
      localStringBuilder.append("::");
      localStringBuilder.append(this.o);
      QLog.i("QQLiveGiftAnimationEngineImpl", 1, localStringBuilder.toString());
    }
    if (paramGiftAnimData.b == 0)
    {
      j();
      return;
    }
    if (paramGiftAnimData.b == 1) {
      if (paramGiftAnimData.m == 1)
      {
        if (this.o)
        {
          if (this.n)
          {
            this.p.b();
            return;
          }
          if (!this.m)
          {
            QLog.e("QQLiveGiftAnimationEngineImpl", 1, "banner is over but giftAnimation is not start");
            this.a.a();
            this.p.b();
          }
        }
      }
      else
      {
        h.put(i(paramGiftAnimData), paramGiftAnimData);
        this.p.b();
      }
    }
  }
  
  private void e(GiftAnimData paramGiftAnimData)
  {
    if (paramGiftAnimData.o == 0) {
      paramGiftAnimData.o = 1;
    }
    this.n = false;
    this.o = false;
    this.m = false;
    this.l = paramGiftAnimData;
    if (paramGiftAnimData.b == 0)
    {
      this.a.a(paramGiftAnimData);
      return;
    }
    if (paramGiftAnimData.b == 1)
    {
      if (paramGiftAnimData.m == 1) {
        this.a.a(paramGiftAnimData);
      }
      this.p.a(paramGiftAnimData, paramGiftAnimData.p);
    }
  }
  
  private boolean f(GiftAnimData paramGiftAnimData)
  {
    GiftAnimData localGiftAnimData = this.l;
    return (localGiftAnimData != null) && (localGiftAnimData.f != 100) && (paramGiftAnimData.f == 100);
  }
  
  private boolean g(GiftAnimData paramGiftAnimData)
  {
    return paramGiftAnimData.f == 100;
  }
  
  private boolean h(GiftAnimData paramGiftAnimData)
  {
    return (paramGiftAnimData.b == 1) && (paramGiftAnimData.m == 0) && (paramGiftAnimData.o > 0);
  }
  
  private String i(GiftAnimData paramGiftAnimData)
  {
    if (paramGiftAnimData == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramGiftAnimData.g);
    localStringBuilder.append(paramGiftAnimData.i);
    localStringBuilder.append(paramGiftAnimData.n);
    return localStringBuilder.toString();
  }
  
  private String j(GiftAnimData paramGiftAnimData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dataType：");
    localStringBuilder.append(paramGiftAnimData.b);
    localStringBuilder.append(" level:");
    localStringBuilder.append(paramGiftAnimData.m);
    localStringBuilder.append(" origNum:");
    localStringBuilder.append(paramGiftAnimData.p);
    localStringBuilder.append(" num:");
    localStringBuilder.append(paramGiftAnimData.o);
    return localStringBuilder.toString();
  }
  
  private void j()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayEnd ");
    ((StringBuilder)localObject).append(j(this.l));
    QLog.i("QQLiveGiftAnimationEngineImpl", 1, ((StringBuilder)localObject).toString());
    if (this.j.size() > 0) {
      localObject = (GiftAnimData)this.j.remove(0);
    } else if (this.k.size() > 0) {
      localObject = (GiftAnimData)this.k.remove(0);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play next: ");
      localStringBuilder.append(j((GiftAnimData)localObject));
      QLog.i("QQLiveGiftAnimationEngineImpl", 1, localStringBuilder.toString());
      this.i.remove(i((GiftAnimData)localObject));
      this.q = 1;
      e((GiftAnimData)localObject);
      return;
    }
    QLog.i("QQLiveGiftAnimationEngineImpl", 1, "queue is play complete");
    this.q = 0;
  }
  
  private void k()
  {
    GiftAnimData localGiftAnimData = this.l;
    if (localGiftAnimData != null)
    {
      if (this.q == 2) {
        return;
      }
      this.q = 2;
      if (localGiftAnimData.b == 1)
      {
        if (this.l.m == 0)
        {
          this.p.a();
          return;
        }
        this.p.a();
        this.a.a();
        return;
      }
      this.a.a();
    }
  }
  
  public void a()
  {
    QLog.i("QQLiveGiftAnimationEngineImpl", 1, "prepare");
    super.a();
    BannerResManager localBannerResManager = BannerResManager.a(this.c.g());
    localBannerResManager.c();
    this.p = new GiftBannerContainer(this.d, localBannerResManager);
    this.p.setBannerListener(this);
    this.a.a(this);
  }
  
  public void a(GiftAnimData paramGiftAnimData, int paramInt)
  {
    try
    {
      boolean bool = this.f;
      if (bool) {
        return;
      }
      if (this.q != 0)
      {
        c(paramGiftAnimData, paramInt);
      }
      else
      {
        if (h(paramGiftAnimData))
        {
          localObject = (GiftAnimData)h.get(i(paramGiftAnimData));
          if (localObject != null)
          {
            if (((GiftAnimData)localObject).o >= paramGiftAnimData.o)
            {
              QLog.i("QQLiveGiftAnimationEngineImpl", 1, "try to play but hitSeq is over");
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QQLiveGiftAnimationEngineImpl", 1, "try to play hitSeq is old updateOriginalNum");
            }
            paramGiftAnimData.p = (((GiftAnimData)localObject).o + 1);
          }
        }
        this.q = 1;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startPlay ");
        ((StringBuilder)localObject).append(j(paramGiftAnimData));
        QLog.i("QQLiveGiftAnimationEngineImpl", 1, ((StringBuilder)localObject).toString());
        e(paramGiftAnimData);
      }
      return;
    }
    finally {}
  }
  
  public void b(GiftAnimData paramGiftAnimData, int paramInt)
  {
    try
    {
      if (paramGiftAnimData != this.l)
      {
        QLog.e("QQLiveGiftAnimationEngineImpl", 1, "bannerAnimation end but data not match");
        return;
      }
      this.o = true;
      d(paramGiftAnimData);
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      g();
      super.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(GiftAnimData paramGiftAnimData)
  {
    try
    {
      if (paramGiftAnimData != this.l) {
        QLog.e("QQLiveGiftAnimationEngineImpl", 1, "bannerAnimation start but data not match");
      }
      this.o = false;
      return;
    }
    finally {}
  }
  
  public View f()
  {
    return this.p;
  }
  
  public void g()
  {
    try
    {
      QLog.i("QQLiveGiftAnimationEngineImpl", 1, "reset");
      super.g();
      this.k.clear();
      this.j.clear();
      this.i.clear();
      if (this.a != null) {
        this.a.a();
      }
      this.p.a();
      return;
    }
    finally {}
  }
  
  public void h() {}
  
  public void i()
  {
    try
    {
      j();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onAnimationEnd(GiftAnimData paramGiftAnimData)
  {
    try
    {
      if (paramGiftAnimData != this.l)
      {
        QLog.e("QQLiveGiftAnimationEngineImpl", 1, "giftAnimation end but data not match");
        return;
      }
      this.a.setVisibility(4);
      this.n = true;
      d(paramGiftAnimData);
      return;
    }
    finally {}
  }
  
  public void onAnimationStart(GiftAnimData paramGiftAnimData)
  {
    if (paramGiftAnimData != this.l) {
      QLog.e("QQLiveGiftAnimationEngineImpl", 1, "giftAnimation start but data not match");
    }
    this.a.setVisibility(0);
    this.m = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.QQLiveGiftAnimationEngineImpl
 * JD-Core Version:    0.7.0.1
 */