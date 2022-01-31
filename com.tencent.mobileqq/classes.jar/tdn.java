import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class tdn
  extends tdo
{
  protected int a;
  protected StoryVideoItem a;
  protected int b = -1;
  protected int c = -1;
  protected String c;
  protected int d;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  
  public tdn()
  {
    this.jdField_d_of_type_Int = 1;
  }
  
  public final void a(tes paramtes)
  {
    super.a(paramtes);
    paramtes.a = a(6);
  }
  
  public final void a(teu paramteu)
  {
    super.a(paramteu);
    paramteu.b = 0;
    paramteu.jdField_d_of_type_JavaLangString = this.k;
    paramteu.a = this.a.mVideoThumbnailUrl;
    paramteu.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramteu.h = a(1);
    if (this.b != -1) {
      paramteu.jdField_d_of_type_Int = this.b;
    }
    if (this.c != -1) {
      paramteu.jdField_e_of_type_Int = this.c;
    }
  }
  
  public final void a(tev paramtev)
  {
    super.a(paramtev);
    paramtev.a = this.a.mVideoThumbnailUrl;
    paramtev.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramtev.jdField_d_of_type_JavaLangString = this.i;
    paramtev.jdField_e_of_type_JavaLangString = a(2);
  }
  
  public final void a(tew paramtew)
  {
    super.a(paramtew);
    paramtew.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtew.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramtew.jdField_d_of_type_JavaLangString)) {
      paramtew.jdField_d_of_type_JavaLangString = tfe.a(paramtew.jdField_e_of_type_JavaLangString);
    }
    paramtew.jdField_c_of_type_JavaLangString = a(5);
    paramtew.a = this.j;
  }
  
  public void a(tex paramtex)
  {
    super.a(paramtex);
    paramtex.jdField_c_of_type_JavaLangString = this.i;
    paramtex.a = this.jdField_e_of_type_JavaLangString;
    paramtex.jdField_d_of_type_JavaLangString = a(3);
    paramtex.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtex.jdField_c_of_type_Boolean = true;
  }
  
  protected void a_(tet paramtet)
  {
    urk.b("Q.qqstory.share.ShareModeBase", "prepareCommonShareData");
    super.a_(paramtet);
    if (this.a.isPollVideo()) {
      paramtet.a("vote", "1");
    }
    for (;;)
    {
      paramtet.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramtet.a("grade", "1");
      }
    }
  }
  
  public void b(tex paramtex)
  {
    super.b(paramtex);
    paramtex.jdField_c_of_type_JavaLangString = this.i;
    paramtex.a = this.jdField_d_of_type_JavaLangString;
    paramtex.jdField_d_of_type_JavaLangString = a(4);
    paramtex.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtex.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdn
 * JD-Core Version:    0.7.0.1
 */