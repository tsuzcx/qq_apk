import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class shx
  extends sie
{
  public shx(shu paramshu)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, shp paramshp)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramshp);
    a(paramString, paramInt1, paramErrorMessage, paramshp);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, shp paramshp)
  {
    shw localshw = this.a.jdField_a_of_type_Shw;
    if (localshw == null) {}
    label14:
    label169:
    do
    {
      break label14;
      do
      {
        return;
      } while (!TextUtils.equals(paramString, localshw.jdField_a_of_type_JavaLangString));
      if (paramErrorMessage.isFail()) {
        if (!TextUtils.isEmpty(localshw.b)) {
          break label136;
        }
      }
      for (paramErrorMessage = paramErrorMessage.errorMsg;; paramErrorMessage = paramErrorMessage.errorMsg + " | " + paramErrorMessage.errorMsg)
      {
        localshw.b = paramErrorMessage;
        localshw.jdField_a_of_type_Int = (paramInt + 1000);
        if ((!paramshp.a.containsKey("handleCallback")) || (localshw.jdField_a_of_type_Boolean)) {
          break;
        }
        localshw.jdField_a_of_type_Boolean = true;
        if (!this.a.a(paramString)) {
          break label169;
        }
        if (this.a.jdField_a_of_type_Shy == null) {
          break;
        }
        this.a.jdField_a_of_type_Shy.a(paramString, paramshp.d, paramInt);
        return;
      }
    } while (this.a.jdField_a_of_type_Shy == null);
    label136:
    this.a.jdField_a_of_type_Shy.a(paramString, paramshp.d, localshw.a(), paramInt);
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, shp paramshp)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramshp);
    a(paramString, paramInt1, new ErrorMessage(), paramshp);
  }
  
  public void b(String paramString, int paramInt, shp paramshp)
  {
    super.b(paramString, paramInt, paramshp);
    if ((this.a.jdField_a_of_type_Shy != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_Shy.b(paramString, paramshp.d, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     shx
 * JD-Core Version:    0.7.0.1
 */