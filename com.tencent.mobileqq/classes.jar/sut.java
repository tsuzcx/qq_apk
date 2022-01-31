import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class sut
  extends sva
{
  public sut(suq paramsuq)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, sul paramsul)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramsul);
    a(paramString, paramInt1, paramErrorMessage, paramsul);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, sul paramsul)
  {
    sus localsus = this.a.jdField_a_of_type_Sus;
    if (localsus == null) {}
    label14:
    label169:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localsus.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localsus.b)) {
          break label136;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localsus.b = paramErrorMessage;
        localsus.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramsul.a.containsKey("handleCallback")) || (localsus.jdField_a_of_type_Boolean)) {
          break;
        }
        localsus.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label169;
        }
        if (this.a.jdField_a_of_type_Suu == null) {
          break;
        }
        this.a.jdField_a_of_type_Suu.a(paramString, paramsul.d, paramInt);
        return;
      }
    } while (this.a.jdField_a_of_type_Suu == null);
    label136:
    this.a.jdField_a_of_type_Suu.a(paramString, paramsul.d, localsus.a(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, sul paramsul)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramsul);
    a(paramString, paramInt1, new ErrorMessage(), paramsul);
  }
  
  public void b(String paramString, int paramInt, sul paramsul)
  {
    super.b(paramString, paramInt, paramsul);
    if ((this.a.jdField_a_of_type_Suu != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Suu.b(paramString, paramsul.d, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sut
 * JD-Core Version:    0.7.0.1
 */