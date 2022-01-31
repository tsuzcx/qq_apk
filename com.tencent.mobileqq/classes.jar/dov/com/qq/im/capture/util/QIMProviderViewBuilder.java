package dov.com.qq.im.capture.util;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ComboProviderView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.QIMPtvTemplateProviderView;
import dov.com.qq.im.capture.view.SpeedProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.ArrayList;

public class QIMProviderViewBuilder
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c;
  public static final int[] d;
  public static final int[] e = { 104, 2130845385, 2130845385, 2131362490 };
  public static final int[] f = { 105, 2130845382, 2130845382, 2131362491 };
  public static final int[] g = { 107, 2130841782, 2130841782, 2131362492 };
  private int jdField_a_of_type_Int = 0;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 108, 2130845383, 2130841712, 2131362486 };
    jdField_b_of_type_ArrayOfInt = new int[] { 101, 2130845384, 2130841792, 2131362487 };
    jdField_c_of_type_ArrayOfInt = new int[] { 102, 2130845386, 2130841991, 2131362488 };
    jdField_d_of_type_ArrayOfInt = new int[] { 103, 2130845387, 2130845387, 2131362489 };
  }
  
  public QIMProviderViewBuilder(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[1];
  }
  
  public ProviderView a(Context paramContext, int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    case 106: 
    default: 
      paramContext = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ProviderViewBuilder", 2, "bad id=" + paramInt);
        paramContext = localObject;
      }
      break;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        paramContext.setCaptureScene(this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Int != 0) {
          break;
        }
        paramContext.setTabBarPosition(2);
        paramContext.d(206);
      }
      return paramContext;
      paramContext = new ComboProviderView(paramContext);
      paramContext.setId(2131362414);
      continue;
      paramContext = new QIMFilterProviderView(paramContext);
      paramContext.setId(2131362415);
      continue;
      paramContext = new StaticStickerProviderView(paramContext);
      paramContext.setId(2131362416);
      continue;
      paramContext = new QIMPtvTemplateProviderView(paramContext);
      continue;
      paramContext = new MusicProviderView(paramContext);
      paramContext.setId(2131362417);
      continue;
      paramContext = new AdvancedProviderView(paramContext);
      paramContext.setNeedTabBar(false);
      continue;
      paramContext = new SpeedProviderView(paramContext);
      paramContext.setNeedTabBar(false);
    }
    paramContext.setTabBarPosition(1);
    if (paramContext.e())
    {
      paramContext.d(213);
      return paramContext;
    }
    paramContext.d(249);
    return paramContext;
  }
  
  public void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
    case 1: 
    case 3: 
      do
      {
        do
        {
          do
          {
            return;
          } while (!this.jdField_a_of_type_Boolean);
          this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(e);
          if (this.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
          }
        } while (!this.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_JavaUtilArrayList.add(f);
        return;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(g);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(e);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      if (QLog.isColorLevel()) {
        QLog.e("ProviderViewBuilder", 2, "updateRedDotHasShow failed out bounds" + paramInt + " size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    do
    {
      return;
      paramInt = ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
      if (paramInt == 101)
      {
        VideoFilterTools.a().a(1, 0, "");
        return;
      }
      if (paramInt == 108)
      {
        VideoFilterTools.a().a(6, 0, "");
        return;
      }
    } while (paramInt != 102);
    ((QIMPtvTemplateManager)QIMManager.a(3)).a(1, 0, "");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return false;
    }
    paramInt = ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
    if (paramInt == 101) {
      return VideoFilterTools.a().a(1, 0, "");
    }
    if (paramInt == 108) {
      return VideoFilterTools.a().a(6, 0, "");
    }
    if (paramInt == 102) {
      return ((QIMPtvTemplateManager)QIMManager.a(3)).a(1, 0, "");
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[3];
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public int c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[2];
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public int d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return -1;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int e(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (paramInt == ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.util.QIMProviderViewBuilder
 * JD-Core Version:    0.7.0.1
 */