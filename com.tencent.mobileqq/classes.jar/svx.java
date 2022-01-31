import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class svx
  extends svu
{
  public svx(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131495711);
  }
  
  public void a()
  {
    this.a.setTag(2131307635, null);
  }
  
  public void a(ssm paramssm)
  {
    super.a(paramssm);
    this.a.setDisplayState(2);
    c(paramssm.jdField_b_of_type_JavaLangString);
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramssm.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramssm.c))
      {
        str = ajjy.a(2131647474);
        localStoryMsgNodeFrameLayout.setNodeName(str, paramssm.j);
        if ((paramssm.jdField_a_of_type_JavaUtilList == null) || (paramssm.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.a.a(1, 1 - paramssm.jdField_b_of_type_Int);
        }
        str = (String)this.a.getTag(2131307635);
        if (!TextUtils.equals(paramssm.jdField_a_of_type_JavaLangString, str)) {
          switch (paramssm.jdField_a_of_type_Int)
          {
          default: 
            str = "unknown";
          }
        }
      }
    }
    for (;;)
    {
      urp.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { paramssm.jdField_a_of_type_JavaLangString, str });
      this.a.setTag(2131307635, paramssm.jdField_a_of_type_JavaLangString);
      return;
      str = paramssm.c;
      break;
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramssm.c)) {}
      for (str = ajjy.a(2131647481);; str = paramssm.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, false);
        break;
      }
      str = "2";
      continue;
      str = "3";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svx
 * JD-Core Version:    0.7.0.1
 */