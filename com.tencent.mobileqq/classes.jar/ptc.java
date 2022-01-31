import android.content.Context;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.widget.AbsListView.LayoutParams;

public class ptc
  extends pqq
{
  public ptc(Context paramContext, baxy parambaxy, ram paramram)
  {
    super(paramContext, parambaxy, paramram);
  }
  
  public pqq a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g();
  }
  
  public pqq d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    ComponentContentVerticalSmallVideo localComponentContentVerticalSmallVideo = (ComponentContentVerticalSmallVideo)this.jdField_a_of_type_Pqp;
    Pair localPair;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof pbf)))
    {
      localPair = omr.a(((pbf)this.jdField_a_of_type_JavaLangObject).f(), ((pbf)this.jdField_a_of_type_JavaLangObject).e());
      if (!onh.s(((pbf)this.jdField_a_of_type_JavaLangObject).a())) {
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
  
  public pqq e()
  {
    return null;
  }
  
  public pqq g()
  {
    this.jdField_a_of_type_Pqp = new ComponentContentVerticalSmallVideo(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ptc
 * JD-Core Version:    0.7.0.1
 */