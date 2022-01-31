import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class suq
  extends sux
{
  public suq(sun paramsun)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, sui paramsui)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramsui);
    a(paramString, paramInt1, paramErrorMessage, paramsui);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, sui paramsui)
  {
    sup localsup = this.a.jdField_a_of_type_Sup;
    if (localsup == null) {}
    label14:
    label169:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localsup.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localsup.b)) {
          break label136;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localsup.b = paramErrorMessage;
        localsup.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramsui.a.containsKey("handleCallback")) || (localsup.jdField_a_of_type_Boolean)) {
          break;
        }
        localsup.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label169;
        }
        if (this.a.jdField_a_of_type_Sur == null) {
          break;
        }
        this.a.jdField_a_of_type_Sur.a(paramString, paramsui.d, paramInt);
        return;
      }
    } while (this.a.jdField_a_of_type_Sur == null);
    label136:
    this.a.jdField_a_of_type_Sur.a(paramString, paramsui.d, localsup.a(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, sui paramsui)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramsui);
    a(paramString, paramInt1, new ErrorMessage(), paramsui);
  }
  
  public void b(String paramString, int paramInt, sui paramsui)
  {
    super.b(paramString, paramInt, paramsui);
    if ((this.a.jdField_a_of_type_Sur != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Sur.b(paramString, paramsui.d, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suq
 * JD-Core Version:    0.7.0.1
 */