import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;

public class oxd
  implements bcya, bcyc, bnkw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private oxe jdField_a_of_type_Oxe;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c;
  
  public oxd(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (bnky.a(bnkt.jdField_b_of_type_Bnkt) != 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  private void a(int paramInt)
  {
    b();
    if (this.jdField_a_of_type_Oxe != null) {
      this.jdField_a_of_type_Oxe.a(paramInt);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      bnku.a().a(this);
    }
  }
  
  private void c()
  {
    if ((this.b) && ((this.c) || (!this.jdField_a_of_type_Boolean))) {
      a(1);
    }
  }
  
  public void a()
  {
    ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  public void a(oxe paramoxe)
  {
    this.jdField_a_of_type_Oxe = paramoxe;
  }
  
  public void onAEDownloadFinish(bnkt parambnkt, String paramString, boolean paramBoolean, int paramInt)
  {
    if (parambnkt.jdField_b_of_type_JavaLangString.equals(bnkt.jdField_b_of_type_Bnkt.jdField_b_of_type_JavaLangString))
    {
      if (paramInt != 0)
      {
        bnrh.d("ReadInJoyCameraCaptureSoManager", "[onAEDownloadFinish] error :" + paramInt);
        a(3);
      }
    }
    else {
      return;
    }
    bnrh.d("ReadInJoyCameraCaptureSoManager", "[onAEDownloadFinish] success");
    this.c = true;
    c();
  }
  
  public void onAEProgressUpdate(bnkt parambnkt, long paramLong1, long paramLong2) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = 1;
    VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
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
      if (bnky.a(bnkt.jdField_b_of_type_Bnkt) == 2)
      {
        bnku.a().a(bnkt.jdField_b_of_type_Bnkt, this, false);
        paramInt1 = j;
      }
    }
    for (;;)
    {
      i = paramInt1;
      break;
      this.c = true;
      VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", "onConfigResult| getFilterSoState != 2", null);
      paramInt1 = j;
      continue;
      paramInt1 = 1;
    }
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
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
      VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label62:
      this.b = true;
      c();
    }
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad("ReadInJoyCameraCaptureSoManager", "onNetWorkNone", null);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxd
 * JD-Core Version:    0.7.0.1
 */