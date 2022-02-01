import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;

public class ovh
  implements bcfe, bcfg, bnpw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ovi jdField_a_of_type_Ovi;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c;
  
  public ovh(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (bnpy.a(bnpt.jdField_b_of_type_Bnpt) != 0) {}
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
    if (this.jdField_a_of_type_Ovi != null) {
      this.jdField_a_of_type_Ovi.a(paramInt);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      bnpu.a().a(this);
    }
  }
  
  private void d()
  {
    if ((this.b) && ((this.c) || (!this.jdField_a_of_type_Boolean))) {
      a(1);
    }
  }
  
  public void B_()
  {
    VideoEnvironment.a("ReadInJoyCameraCaptureSoManager", "onNetWorkNone", null);
  }
  
  public void a()
  {
    ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = 1;
    VideoEnvironment.a("ReadInJoyCameraCaptureSoManager", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    int i;
    if (paramInt1 != 1)
    {
      i = k;
      if (paramInt1 != 0) {}
    }
    else
    {
      if (paramInt2 == 0) {
        break label69;
      }
      i = k;
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
      if (bnpy.a(bnpt.jdField_b_of_type_Bnpt) == 2)
      {
        bnpu.a().a(bnpt.jdField_b_of_type_Bnpt, this, false);
        paramInt1 = j;
      }
    }
    for (;;)
    {
      i = paramInt1;
      break;
      this.c = true;
      VideoEnvironment.a("ReadInJoyCameraCaptureSoManager", "onConfigResult| getFilterSoState != 2", null);
      paramInt1 = j;
      continue;
      paramInt1 = 1;
    }
  }
  
  public void a(bnpt parambnpt, long paramLong1, long paramLong2) {}
  
  public void a(bnpt parambnpt, String paramString, boolean paramBoolean, int paramInt)
  {
    if (parambnpt.jdField_b_of_type_JavaLangString.equals(bnpt.jdField_b_of_type_Bnpt.jdField_b_of_type_JavaLangString))
    {
      if (paramInt != 0)
      {
        bnzb.d("ReadInJoyCameraCaptureSoManager", "[onAEDownloadFinish] error :" + paramInt);
        a(3);
      }
    }
    else {
      return;
    }
    bnzb.d("ReadInJoyCameraCaptureSoManager", "[onAEDownloadFinish] success");
    this.c = true;
    d();
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label62;
      }
      a(3);
    }
    for (;;)
    {
      VideoEnvironment.a("ReadInJoyCameraCaptureSoManager", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label62:
      this.b = true;
      d();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
  
  public void a(ovi paramovi)
  {
    this.jdField_a_of_type_Ovi = paramovi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovh
 * JD-Core Version:    0.7.0.1
 */