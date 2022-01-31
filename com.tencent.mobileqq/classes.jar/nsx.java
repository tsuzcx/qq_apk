import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;

public class nsx
  implements awfg, awfi
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private nsy jdField_a_of_type_Nsy;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c;
  
  public nsx(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (awlw.a(paramContext) != 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  private void a(int paramInt)
  {
    c();
    if (this.jdField_a_of_type_Nsy != null) {
      this.jdField_a_of_type_Nsy.a(paramInt);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
  }
  
  private void d()
  {
    if ((this.b) && ((this.c) || (!this.jdField_a_of_type_Boolean))) {
      a(1);
    }
  }
  
  public void I_()
  {
    VideoEnvironment.a("ReadInJoyCameraCaptureSoManager", "onNetWorkNone", null);
  }
  
  public void a()
  {
    ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = 1;
    VideoEnvironment.a("ReadInJoyCameraCaptureSoManager", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    int k = 0;
    int i;
    if (paramInt1 != 1)
    {
      i = j;
      if (paramInt1 != 0) {}
    }
    else
    {
      if (paramInt2 == 0) {
        break label69;
      }
      i = j;
    }
    if (i != 0) {
      a(3);
    }
    return;
    label69:
    ArrayList localArrayList = new ArrayList(1);
    if (ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList) == 0)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
      if (awlw.a(VideoEnvironment.a()) == 2)
      {
        ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        paramInt1 = k;
      }
    }
    for (;;)
    {
      i = paramInt1;
      break;
      this.c = true;
      VideoEnvironment.a("ReadInJoyCameraCaptureSoManager", "onConfigResult| getFilterSoState != 2", null);
      paramInt1 = k;
      continue;
      paramInt1 = 1;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt != 0) {
        a(3);
      }
    }
    else if (paramString1.startsWith("new_qq_android_native_short_filter_"))
    {
      if (paramInt == 0) {
        break label92;
      }
      a(3);
    }
    for (;;)
    {
      VideoEnvironment.a("ReadInJoyCameraCaptureSoManager", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.b = true;
      d();
      break;
      label92:
      this.c = true;
      d();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
  
  public void a(nsy paramnsy)
  {
    this.jdField_a_of_type_Nsy = paramnsy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nsx
 * JD-Core Version:    0.7.0.1
 */