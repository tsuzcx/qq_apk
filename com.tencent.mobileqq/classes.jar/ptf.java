import android.content.Context;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.widget.AbsListView.LayoutParams;

public class ptf
  extends pqt
{
  public ptf(Context paramContext, baxk parambaxk, rap paramrap)
  {
    super(paramContext, parambaxk, paramrap);
  }
  
  public pqt a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g();
  }
  
  public pqt d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    ComponentContentVerticalSmallVideo localComponentContentVerticalSmallVideo = (ComponentContentVerticalSmallVideo)this.jdField_a_of_type_Pqs;
    Pair localPair;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof pbi)))
    {
      localPair = omu.a(((pbi)this.jdField_a_of_type_JavaLangObject).f(), ((pbi)this.jdField_a_of_type_JavaLangObject).e());
      if (!onk.s(((pbi)this.jdField_a_of_type_JavaLangObject).a())) {
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
  
  public pqt e()
  {
    return null;
  }
  
  public pqt g()
  {
    this.jdField_a_of_type_Pqs = new ComponentContentVerticalSmallVideo(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ptf
 * JD-Core Version:    0.7.0.1
 */