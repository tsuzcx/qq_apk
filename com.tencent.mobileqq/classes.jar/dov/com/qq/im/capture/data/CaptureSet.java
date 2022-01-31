package dov.com.qq.im.capture.data;

import android.app.Activity;
import android.os.Bundle;
import anty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.CaptureComboMusic;
import dov.com.qq.im.capture.music.QimMusicPlayer;
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

public class CaptureSet
  extends CaptureComboBase
  implements CaptureComboDownloadListener
{
  float jdField_a_of_type_Float = 1.0F;
  public long a;
  public WeakReference a;
  private final CopyOnWriteArraySet jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public boolean a;
  public ArrayList b = new ArrayList();
  
  public CaptureSet(Object paramObject)
  {
    super(paramObject);
  }
  
  public float a()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      float f2;
      float f3;
      for (float f1 = 0.0F; localIterator.hasNext(); f1 += f3 * f2)
      {
        CaptureComboBase localCaptureComboBase = (CaptureComboBase)localIterator.next();
        f2 = localCaptureComboBase.a();
        if (QLog.isDevelopLevel()) {
          QLog.i("QCombo", 2, "getProgress " + localCaptureComboBase.toString() + " progress =" + f2);
        }
        f3 = this.jdField_a_of_type_Float;
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
      Iterator localIterator = this.b.iterator();
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
          QLog.i("QCombo", 2, localStringBuilder.toString());
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
        } while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 60000L);
        b(2);
        a(2);
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
    if ((this instanceof ComboSet)) {
      if (CaptureComboFilter.a((ComboSet)this, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "apply already" + toString());
        }
        VideoFilterTools.a().a((ComboSet)this, paramActivity, paramInt);
      }
    }
    label337:
    do
    {
      Object localObject1;
      Object localObject3;
      do
      {
        do
        {
          do
          {
            return 0;
            localObject2 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject;
            if ((localObject2 != null) && (paramInt == 0))
            {
              localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
              if ("back".equals(((QIMFilterCategoryItem)localObject2).f))
              {
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt(CameraControl.b, 2);
                ((AppRuntime)localObject1).notifyObservers(CaptureComboObeserver.class, 970, true, (Bundle)localObject2);
              }
            }
            else
            {
              localObject1 = VideoFilterTools.a().a[paramInt];
              if (localObject1 != null) {
                ((ComboSet)localObject1).a(paramActivity, paramInt);
              }
              VideoFilterTools.a().a((ComboSet)this, paramActivity, paramInt);
              if (QLog.isColorLevel()) {
                QLog.i("QCombo", 2, "apply " + toString() + ", " + paramInt);
              }
              localObject1 = new ArrayList();
              localObject2 = this.b.iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label337;
              }
              localObject3 = (CaptureComboBase)((Iterator)localObject2).next();
              if ((localObject3 instanceof CaptureComboFilter))
              {
                ((List)localObject1).add(((CaptureComboFilter)localObject3).a);
                continue;
                if ((!"front".equals(((QIMFilterCategoryItem)localObject2).f)) || (!CameraAbility.c())) {
                  break;
                }
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt(CameraControl.b, 1);
                ((AppRuntime)localObject1).notifyObservers(CaptureComboObeserver.class, 970, true, (Bundle)localObject2);
                break;
              }
              ((CaptureComboBase)localObject3).a(paramActivity, paramInt);
            }
          } while (!(this instanceof ComboSet));
          localObject2 = (CaptureComboManager)QIMManager.a(5);
          if (localObject2.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[paramInt].a()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QCombo", 2, "apply " + toString() + ", " + paramInt + " comboApplyFilterAborted");
        return 0;
        localObject2.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[paramInt].a(null);
        localObject3 = ((CaptureComboManager)localObject2).jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
      } while (localObject3 == null);
      Object localObject2 = ((CaptureComboManager)localObject2).a((ComboSet)this, ((VideoFilterTools.ComboFilterData)localObject3).a(paramInt).c);
      VideoFilterTools.a().b((QIMFilterCategoryItem)localObject2, paramActivity, paramInt);
      CaptureComboFilter.a(paramActivity, (List)localObject1, this, paramInt);
      paramActivity = this.jdField_a_of_type_JavaLangObject;
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) || (!((QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject).c()) || (paramInt == 1) || (paramInt == 3));
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
      QLog.i("QCombo", 2, "unApply " + toString() + ", " + paramInt);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      CaptureComboBase localCaptureComboBase = (CaptureComboBase)localIterator.next();
      if (((localCaptureComboBase instanceof CaptureComboMusic)) && ((paramInt == 2) || (paramInt == 4))) {
        ((CaptureComboMusic)localCaptureComboBase).c(paramActivity, paramInt);
      } else {
        localCaptureComboBase.a(paramActivity, paramInt);
      }
    }
  }
  
  public void a(CaptureComboBase paramCaptureComboBase)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadStart " + toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
  }
  
  public void a(CaptureComboBase paramCaptureComboBase, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramCaptureComboBase);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadError " + toString() + ":" + paramCaptureComboBase.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
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
      QLog.i("QCombo", 2, "download " + toString());
    }
    if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
    {
      a(3);
      return 2;
    }
    ThreadManager.getSubThreadHandler().post(new anty(this));
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {
      return ((QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject).a;
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
  
  public void b(CaptureComboBase paramCaptureComboBase)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramCaptureComboBase);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadSuccess= " + toString() + ":" + paramCaptureComboBase.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      if (this.jdField_a_of_type_Boolean)
      {
        b(2);
        a(1);
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
    Object localObject = this.b.iterator();
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
          QLog.i("QCombo", 2, "download " + toString() + "  " + localCaptureComboBase.toString());
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
          QLog.i("QCombo", 2, "downloading " + toString() + ":" + localCaptureComboBase.toString());
        }
        k = 1;
        j = i;
        i = k;
        continue;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
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
  
  public void c(CaptureComboBase paramCaptureComboBase)
  {
    this.b.add(paramCaptureComboBase);
    this.jdField_a_of_type_Float = (1.0F / this.b.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureSet
 * JD-Core Version:    0.7.0.1
 */