import android.content.Context;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.widget.AbsListView.LayoutParams;

public class phk
  extends pez
{
  public phk(Context paramContext, azwg paramazwg, qoe paramqoe)
  {
    super(paramContext, paramazwg, paramqoe);
  }
  
  public pez a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g();
  }
  
  public pez d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    ComponentContentVerticalSmallVideo localComponentContentVerticalSmallVideo = (ComponentContentVerticalSmallVideo)this.jdField_a_of_type_Pey;
    Pair localPair;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof oqh)))
    {
      localPair = obj.a(((oqh)this.jdField_a_of_type_JavaLangObject).f(), ((oqh)this.jdField_a_of_type_JavaLangObject).e());
      if (!obz.s(((oqh)this.jdField_a_of_type_JavaLangObject).a())) {
        break label105;
      }
      localComponentContentVerticalSmallVideo.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
    }
    for (;;)
    {
      a(localComponentContentVerticalSmallVideo);
      return this;
      label105:
      localComponentContentVerticalSmallVideo.setLayoutParams(new AbsListView.LayoutParams(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue()));
    }
  }
  
  public pez e()
  {
    return null;
  }
  
  public pez g()
  {
    this.jdField_a_of_type_Pey = new ComponentContentVerticalSmallVideo(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phk
 * JD-Core Version:    0.7.0.1
 */