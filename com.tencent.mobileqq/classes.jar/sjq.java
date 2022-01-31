import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;

public class sjq
  extends EmoticonPackageDownloadListener
{
  public sjq(EmosmActivity paramEmosmActivity) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    this.a.runOnUiThread(new sjs(this, paramEmoticonPackage, paramInt));
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if ((paramEmoticonPackage == null) || (paramInt1 != 2) || (paramInt2 != 0)) {}
    while (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    this.a.runOnUiThread(this.a.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    this.a.runOnUiThread(new sjr(this, paramEmoticonPackage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjq
 * JD-Core Version:    0.7.0.1
 */