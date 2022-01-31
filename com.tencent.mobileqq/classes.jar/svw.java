import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class svw
  extends svu
{
  public int a;
  
  public svw(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, 2131495711);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ssm paramssm)
  {
    super.a(paramssm);
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      vkw.a(ajjy.a(2131641816), new Object[0]);
      return;
    case 3: 
      this.itemView.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramssm.c, false);
      String str = vmp.b(paramssm.g);
      if (!TextUtils.isEmpty(str)) {
        b(str);
      }
      while ((paramssm.a == null) || (paramssm.a.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(1, 1 - paramssm.b);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.setImageResource(2130845544);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(ajjy.a(2131641815), false);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.setImageResource(2130845541);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svw
 * JD-Core Version:    0.7.0.1
 */