package com.tencent.mobileqq.troop.redpoint;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class DrawRedPointUIComponent
{
  public AppRuntime a;
  private String b;
  private String c;
  private View d;
  private List<Integer> e;
  private RedPointListener f = new DrawRedPointUIComponent.1(this);
  
  public DrawRedPointUIComponent(RedPointUIData paramRedPointUIData)
  {
    if (paramRedPointUIData != null)
    {
      this.a = paramRedPointUIData.g;
      this.b = paramRedPointUIData.a;
      this.c = paramRedPointUIData.b;
      this.e = paramRedPointUIData.e;
      this.d = paramRedPointUIData.c;
    }
    c();
    e();
  }
  
  private void a(RedPointInfo paramRedPointInfo)
  {
    if (paramRedPointInfo != null)
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        if (this.d == null) {
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RedPointItem localRedPointItem = paramRedPointInfo.a(((Integer)((Iterator)localObject).next()).intValue());
          if ((localRedPointItem != null) && (localRedPointItem.unReadNum != 0))
          {
            bool = true;
            break label75;
          }
        }
        boolean bool = false;
        label75:
        if (QLog.isColorLevel())
        {
          paramRedPointInfo = new StringBuilder();
          paramRedPointInfo.append("updateRedPointUI mUin = ");
          paramRedPointInfo.append(this.b);
          paramRedPointInfo.append(",mUinType = ");
          paramRedPointInfo.append(this.c);
          paramRedPointInfo.append(", isShowRedPoint = ");
          paramRedPointInfo.append(bool);
          QLog.d("DrawRedPointUIComponent", 2, paramRedPointInfo.toString());
        }
        if (bool)
        {
          this.d.setVisibility(0);
          return;
        }
        this.d.setVisibility(8);
      }
    }
  }
  
  private void a(RedPointInfo paramRedPointInfo, HashSet<Integer> paramHashSet)
  {
    if ((paramRedPointInfo != null) && (b() != null))
    {
      if (this.d == null) {
        return;
      }
      paramHashSet = b().iterator();
      while (paramHashSet.hasNext())
      {
        RedPointItem localRedPointItem = paramRedPointInfo.a(((Integer)paramHashSet.next()).intValue());
        if ((localRedPointItem != null) && (localRedPointItem.unReadNum != 0))
        {
          bool = true;
          break label76;
        }
      }
      boolean bool = false;
      label76:
      if (QLog.isColorLevel())
      {
        paramRedPointInfo = new StringBuilder();
        paramRedPointInfo.append("UpdateUI: isShowRedPoint = ");
        paramRedPointInfo.append(bool);
        paramRedPointInfo.append(",mUin = ");
        paramRedPointInfo.append(this.b);
        paramRedPointInfo.append(", mUinType = ");
        paramRedPointInfo.append(this.c);
        QLog.d("DrawRedPointUIComponent", 2, paramRedPointInfo.toString());
      }
      if (bool)
      {
        this.d.setVisibility(0);
        return;
      }
      this.d.setVisibility(8);
    }
  }
  
  private boolean a(String paramString1, String paramString2, RedPointInfo paramRedPointInfo, HashSet<Integer> paramHashSet)
  {
    boolean bool4 = TextUtils.isEmpty(this.b);
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    if (!bool4)
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(this.c))
      {
        bool2 = bool1;
        if (this.b.equals(paramString1))
        {
          if (!this.c.equals(paramString2)) {
            return false;
          }
          paramString1 = b();
          bool2 = bool1;
          if (paramRedPointInfo != null)
          {
            bool2 = bool1;
            if (paramHashSet != null)
            {
              if (paramString1 == null) {
                return false;
              }
              paramString1 = paramString1.iterator();
              do
              {
                bool1 = bool3;
                if (!paramString1.hasNext()) {
                  break;
                }
              } while (!paramHashSet.contains((Integer)paramString1.next()));
              bool1 = true;
              bool2 = bool1;
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder();
                paramString1.append("mUin = ");
                paramString1.append(this.b);
                paramString1.append(", mUinType = ");
                paramString1.append(this.c);
                paramString1.append(", needUpdate = ");
                paramString1.append(bool1);
                QLog.d("DrawRedPointUIComponent", 2, paramString1.toString());
                bool2 = bool1;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private void c()
  {
    AppRuntime localAppRuntime = this.a;
    if (localAppRuntime != null) {
      ((IRedPointInfoService)localAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).addRedPointListener(this.f);
    }
  }
  
  private void d()
  {
    AppRuntime localAppRuntime = this.a;
    if (localAppRuntime != null) {
      ((IRedPointInfoService)localAppRuntime.getRuntimeService(IRedPointInfoService.class, "")).removeRedPointListener(this.f);
    }
  }
  
  private void e()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c)))
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initRedPointUI mUin = ");
          ((StringBuilder)localObject).append(this.b);
          ((StringBuilder)localObject).append(",mUinType = ");
          ((StringBuilder)localObject).append(this.c);
          QLog.d("DrawRedPointUIComponent", 2, ((StringBuilder)localObject).toString());
        }
        a(((IRedPointInfoService)this.a.getRuntimeService(IRedPointInfoService.class, "")).getRedPointInfo(this.b, this.c));
      }
    }
  }
  
  public void a()
  {
    d();
    List localList = this.e;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public List<Integer> b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.DrawRedPointUIComponent
 * JD-Core Version:    0.7.0.1
 */