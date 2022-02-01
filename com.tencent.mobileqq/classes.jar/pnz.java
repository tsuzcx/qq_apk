import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.List;

public class pnz
{
  AnimationSet a;
  public pne a;
  
  public pnz(pne parampne)
  {
    this.jdField_a_of_type_Pne = parampne;
  }
  
  public AnimationSet a()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_Pne.a().a(), 2130772058));
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    List localList = this.jdField_a_of_type_AndroidViewAnimationAnimationSet.getAnimations();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      localAnimationSet.addAnimation((Animation)localList.get(i));
      i += 1;
    }
    return localAnimationSet;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_Pne.a().remove(paramBaseArticleInfo);
    this.jdField_a_of_type_Pne.a().a().notifyDataSetChanged();
    this.jdField_a_of_type_Pne.a().e(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnz
 * JD-Core Version:    0.7.0.1
 */