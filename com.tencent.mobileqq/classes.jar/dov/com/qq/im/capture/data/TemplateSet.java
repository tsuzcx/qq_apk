package dov.com.qq.im.capture.data;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.CaptureComboMusic;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class TemplateSet
  extends CaptureSet
  implements CaptureComboDownloadListener
{
  private final CopyOnWriteArraySet<CaptureComboBase> a;
  float b;
  public long b;
  public WeakReference<Activity> b;
  public boolean b;
  public ArrayList<CaptureComboBase> c = new ArrayList();
  
  public TemplateSet(Object paramObject)
  {
    super(paramObject);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public float a()
  {
    try
    {
      Iterator localIterator = this.c.iterator();
      float f2;
      float f3;
      for (float f1 = 0.0F; localIterator.hasNext(); f1 += f3 * f2)
      {
        CaptureComboBase localCaptureComboBase = (CaptureComboBase)localIterator.next();
        f2 = localCaptureComboBase.a();
        if (QLog.isDevelopLevel()) {
          QLog.i("QTemplate", 2, "getProgress " + localCaptureComboBase.toString() + " progress =" + f2);
        }
        f3 = this.jdField_b_of_type_Float;
      }
      return f1;
    }
    catch (Exception localException) {}
    return 0.0F;
  }
  
  public int a()
  {
    int j = 0;
    int k = 1;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("getState = ");
      localStringBuilder.append(toString());
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      Iterator localIterator = this.c.iterator();
      int i;
      if (localIterator.hasNext())
      {
        CaptureComboBase localCaptureComboBase = (CaptureComboBase)localIterator.next();
        i = localCaptureComboBase.a();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(i);
          localStringBuilder.append("|");
          localStringBuilder.append(localCaptureComboBase.toString());
          localStringBuilder.append("   ");
        }
        if (i == 2)
        {
          i = 0;
          j = 1;
        }
      }
      for (;;)
      {
        label125:
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, localStringBuilder.toString());
        }
        if (j != 0)
        {
          b(2);
          i = 2;
        }
        do
        {
          return i;
          if (i != 1) {
            break;
          }
          i = 1;
          break label125;
          if (i == 0) {
            break label211;
          }
          if (this.jdField_a_of_type_Int != 1) {
            b();
          }
          i = k;
        } while (System.currentTimeMillis() - this.jdField_b_of_type_Long <= 15000L);
        b(2);
        a(5);
        return 2;
        label211:
        b(3);
        return 3;
        i = 0;
      }
      localStringBuilder = null;
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    Object localObject1;
    if ((this instanceof TemplateSet))
    {
      localObject1 = (CaptureTemplateManager)QIMManager.a(15);
      if (((CaptureTemplateManager)localObject1).a(this, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "apply already" + toString());
        }
        ((CaptureTemplateManager)localObject1).a(this, paramActivity, paramInt);
      }
    }
    label338:
    do
    {
      Object localObject3;
      do
      {
        do
        {
          do
          {
            return 0;
            localObject3 = (QIMTemplateItem)this.jdField_a_of_type_JavaLangObject;
            if ((localObject3 != null) && (paramInt == 0))
            {
              localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
              if ("back".equals(((QIMTemplateItem)localObject3).f))
              {
                localObject3 = new Bundle();
                ((Bundle)localObject3).putInt(CameraControl.b, 2);
                ((AppRuntime)localObject2).notifyObservers(CaptureComboObeserver.class, 970, true, (Bundle)localObject3);
              }
            }
            else
            {
              localObject2 = localObject1.a[paramInt];
              if (localObject2 != null) {
                ((TemplateSet)localObject2).a(paramActivity, paramInt);
              }
              ((CaptureTemplateManager)localObject1).a(this, paramActivity, paramInt);
              if (QLog.isColorLevel()) {
                QLog.i("QTemplate", 2, "apply " + toString() + ", " + paramInt);
              }
              localObject1 = new ArrayList();
              localObject2 = this.c.iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label338;
              }
              localObject3 = (CaptureComboBase)((Iterator)localObject2).next();
              if ((localObject3 instanceof CaptureComboFilter))
              {
                ((List)localObject1).add(((CaptureComboFilter)localObject3).a);
                continue;
                if ((!"front".equals(((QIMTemplateItem)localObject3).f)) || (!CameraAbility.c())) {
                  break;
                }
                localObject3 = new Bundle();
                ((Bundle)localObject3).putInt(CameraControl.b, 1);
                ((AppRuntime)localObject2).notifyObservers(CaptureComboObeserver.class, 970, true, (Bundle)localObject3);
                break;
              }
              ((CaptureComboBase)localObject3).a(paramActivity, paramInt);
            }
          } while (!(this instanceof TemplateSet));
          localObject2 = (CaptureComboManager)QIMManager.a(5);
          if (((CaptureComboManager)localObject2).a(paramInt).a()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QCombo", 2, "apply " + toString() + ", " + paramInt + " comboApplyFilterAborted");
        return 0;
        localObject3 = ((CaptureComboManager)localObject2).a;
      } while (localObject3 == null);
      Object localObject2 = ((CaptureComboManager)localObject2).a(this, ((VideoFilterTools.ComboFilterData)localObject3).a(paramInt).c);
      if (localObject2 != null) {
        VideoFilterTools.a().b((QIMFilterCategoryItem)localObject2, paramActivity, paramInt);
      }
      VideoFilterTools.a().a((QIMFilterCategoryItem)localObject2, paramInt);
      CaptureComboFilter.a(paramActivity, (List)localObject1, this, paramInt);
      paramActivity = this.jdField_a_of_type_JavaLangObject;
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof QIMTemplateItem)) || (!((QIMTemplateItem)this.jdField_a_of_type_JavaLangObject).a()) || (paramInt == 1) || (paramInt == 3));
    ((QimMusicPlayer)QIMManager.a().c(8)).a(paramInt);
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.b(5);
    if (localCaptureComboManager != null) {
      localCaptureComboManager.a(this, paramInt);
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "unApply " + toString() + ", " + paramInt);
    }
    Object localObject1 = this.c.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CaptureComboBase)((Iterator)localObject1).next();
      if (((localObject2 instanceof CaptureComboMusic)) && ((paramInt == 2) || (paramInt == 4))) {
        ((CaptureComboMusic)localObject2).c(paramActivity, paramInt);
      } else {
        ((CaptureComboBase)localObject2).a(paramActivity, paramInt);
      }
    }
    VideoFilterTools.a().b(null, paramActivity, paramInt);
    localObject1 = (CaptureTemplateManager)QIMManager.a(15);
    Object localObject2 = localObject1.a[paramInt];
    if ((localObject2 != null) && (((TemplateSet)localObject2).b().equals(b()))) {
      ((CaptureTemplateManager)localObject1).a(null, paramActivity, paramInt);
    }
  }
  
  public void a(CaptureComboBase paramCaptureComboBase)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadStart " + toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
  }
  
  public void a(CaptureComboBase paramCaptureComboBase, int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramCaptureComboBase);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadError " + toString() + ":" + paramCaptureComboBase.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      b(2);
      a(paramInt);
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "download " + toString());
    }
    if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
    {
      a(6);
      return 2;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new TemplateSet.1(this));
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {
      return ((QIMTemplateItem)this.jdField_a_of_type_JavaLangObject).a;
    }
    return "unknown" + hashCode();
  }
  
  public void b()
  {
    super.b();
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.b(5);
    if (localCaptureComboManager != null) {
      localCaptureComboManager.a(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "select " + toString());
    }
    QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)this.jdField_a_of_type_JavaLangObject;
    ((CaptureTemplateManager)QIMManager.a(15)).a(localQIMTemplateItem, paramActivity, paramInt);
    ((CaptureComboManager)QIMManager.a(5)).a(paramInt).a(this);
  }
  
  public void b(CaptureComboBase paramCaptureComboBase)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramCaptureComboBase);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadSuccess= " + toString() + ":" + paramCaptureComboBase.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      if (this.jdField_b_of_type_Boolean)
      {
        b(2);
        a(4);
      }
    }
    else {
      return;
    }
    b(3);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadFinish= " + toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
    b();
  }
  
  public int c()
  {
    Object localObject = this.c.iterator();
    int j = 0;
    int i = 0;
    CaptureComboBase localCaptureComboBase;
    if (((Iterator)localObject).hasNext())
    {
      localCaptureComboBase = (CaptureComboBase)((Iterator)localObject).next();
      if (localCaptureComboBase.a() == 2)
      {
        localCaptureComboBase.a(this);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localCaptureComboBase);
        localCaptureComboBase.b();
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "download " + toString() + "  " + localCaptureComboBase.toString());
        }
        i = j;
        j = 1;
      }
    }
    for (;;)
    {
      int k = j;
      j = i;
      i = k;
      break;
      if (localCaptureComboBase.a() == 1)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localCaptureComboBase);
        localCaptureComboBase.a(this);
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "downloading " + toString() + ":" + localCaptureComboBase.toString());
        }
        k = 1;
        j = i;
        i = k;
        continue;
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() > 0)
        {
          b(1);
          a();
          localObject = (CaptureComboManager)QIMManager.b(5);
          if (localObject != null) {
            ((CaptureComboManager)localObject).b(this);
          }
        }
        if ((i != 0) || (j != 0))
        {
          b(1);
          return 1;
        }
        b(3);
        b();
        return 3;
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public void d(CaptureComboBase paramCaptureComboBase)
  {
    this.c.add(paramCaptureComboBase);
    paramCaptureComboBase.c = (this.c.size() - 1);
    this.jdField_b_of_type_Float = (1.0F / this.c.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.TemplateSet
 * JD-Core Version:    0.7.0.1
 */