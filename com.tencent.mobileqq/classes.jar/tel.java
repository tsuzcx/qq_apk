import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class tel
  extends tdo
{
  protected StoryVideoItem a;
  protected int b;
  protected int c;
  protected String c;
  protected int d;
  protected String d;
  protected int e;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  
  public tel()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
  }
  
  protected String a()
  {
    if (this.a.isPollVideo()) {
      return this.jdField_c_of_type_JavaLangString + ajjy.a(2131650582);
    }
    if (this.a.isInteractVideo()) {
      return this.jdField_c_of_type_JavaLangString + ajjy.a(2131650600);
    }
    if (this.a.isGameVideo())
    {
      srt localsrt = this.a.getVideoGameInfo();
      if (localsrt.a == 2) {
        return ajjy.a(2131650584) + localsrt.b + ajjy.a(2131650564);
      }
      if (this.b == 0) {
        return ajjy.a(2131650565) + localsrt.b + localsrt.jdField_c_of_type_JavaLangString + ajjy.a(2131650599);
      }
      return this.a.mOwnerName + ajjy.a(2131650574) + localsrt.b + localsrt.jdField_c_of_type_JavaLangString + ajjy.a(2131650570);
    }
    return this.jdField_c_of_type_JavaLangString + ajjy.a(2131650580) + sfm.a;
  }
  
  public final void a(tes paramtes)
  {
    super.a(paramtes);
    paramtes.a = a(6);
    a(paramtes);
  }
  
  protected void a(tet paramtet) {}
  
  public final void a(teu paramteu)
  {
    super.a(paramteu);
    paramteu.b = 0;
    paramteu.jdField_d_of_type_JavaLangString = this.k;
    paramteu.a = this.a.mVideoThumbnailUrl;
    paramteu.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramteu.j = this.l;
    paramteu.h = a(1);
    if (this.jdField_c_of_type_Int != -1) {
      paramteu.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_d_of_type_Int != -1) {
      paramteu.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
    a(paramteu);
  }
  
  public final void a(tev paramtev)
  {
    super.a(paramtev);
    paramtev.a = this.a.mVideoThumbnailUrl;
    paramtev.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramtev.jdField_d_of_type_JavaLangString = this.i;
    paramtev.jdField_e_of_type_JavaLangString = a(2);
    a(paramtev);
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
    a(paramtew);
  }
  
  public void a(tex paramtex)
  {
    super.a(paramtex);
    paramtex.jdField_c_of_type_JavaLangString = this.i;
    paramtex.a = this.jdField_d_of_type_JavaLangString;
    paramtex.jdField_d_of_type_JavaLangString = a(3);
    paramtex.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtex.jdField_c_of_type_Boolean = true;
    a(paramtex);
  }
  
  protected void a_(tet paramtet)
  {
    urk.b("VideoShareModeBase", "prepareCommonShareData");
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
  
  protected String b()
  {
    Object localObject1 = this.a.getPollLayout();
    Object localObject2 = this.a.getInteractLayout();
    if ((localObject1 != null) && (((srq)localObject1).a != null) && (((srq)localObject1).a.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.a[0];
    }
    if ((localObject2 != null) && (((srp)localObject2).a != null) && (((srp)localObject2).a.length > 0))
    {
      localObject1 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject1 + " · " + localObject2.a[0];
    }
    localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
    if (TextUtils.isEmpty(this.g)) {}
    for (localObject1 = "1个小视频";; localObject1 = this.g) {
      return (String)localObject2 + " · " + (String)localObject1;
    }
  }
  
  public void b(tex paramtex)
  {
    super.b(paramtex);
    paramtex.jdField_c_of_type_JavaLangString = this.i;
    paramtex.a = this.jdField_d_of_type_JavaLangString;
    paramtex.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramtex.jdField_d_of_type_JavaLangString = a(4);
    paramtex.jdField_c_of_type_Boolean = true;
    a(paramtex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tel
 * JD-Core Version:    0.7.0.1
 */