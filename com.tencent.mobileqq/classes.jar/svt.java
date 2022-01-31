import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;

public class svt
  extends svu
{
  public svt(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131495711);
  }
  
  private void c(ssm paramssm)
  {
    paramssm.d = false;
    stf.a(QQStoryContext.a()).a(paramssm);
    stu localstu = new stu();
    localstu.jdField_b_of_type_JavaLangString = paramssm.jdField_a_of_type_JavaLangString;
    localstu.c = paramssm.jdField_a_of_type_Int;
    localstu.d = 4;
    localstu.jdField_b_of_type_Long = paramssm.e;
    slv.a().a(localstu, null);
  }
  
  public void a(ssm paramssm)
  {
    super.a(paramssm);
    if (!TextUtils.isEmpty(paramssm.g)) {
      c(paramssm.g);
    }
    if (!TextUtils.isEmpty(paramssm.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramssm.c)) {}
      for (str = ajjy.a(2131641158);; str = paramssm.c)
      {
        localStoryMsgNodeFrameLayout.setNodeName(str, paramssm.j);
        if (paramssm.d) {
          c(paramssm);
        }
        return;
      }
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout = this.a;
    if (TextUtils.isEmpty(paramssm.c)) {}
    for (String str = ajjy.a(2131641157);; str = paramssm.c)
    {
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
      break;
    }
  }
  
  protected void b(ssm paramssm)
  {
    this.a.setDisplayState(6);
    this.a.a(paramssm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svt
 * JD-Core Version:    0.7.0.1
 */