import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class svz
  extends svu
{
  private boolean a;
  
  public svz(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131495711);
  }
  
  private void a(ssm paramssm, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(paramssm);
      return;
      super.b(paramssm);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
      continue;
      super.b(paramssm);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a();
      continue;
      super.b(paramssm);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
    }
  }
  
  private void c(ssm paramssm)
  {
    if ((paramssm.jdField_b_of_type_Boolean) || (paramssm.d > 0))
    {
      b(paramssm.h);
      if ((!paramssm.jdField_b_of_type_Boolean) && (paramssm.d > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(1);
      }
      for (;;)
      {
        urk.b("VASH", "bindCoverImage: %s", paramssm.h);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
      }
    }
    b(vmp.b(paramssm.g));
    urk.b("VASH", "bindCoverImage: %s", paramssm.g);
  }
  
  public void a(ssm paramssm)
  {
    super.a(paramssm);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(paramssm.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (sqs)sqg.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((sqs)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new srn(String.valueOf(localObject1), "");
        new sxp().a(0, (srn)localObject2, String.valueOf(localObject1));
      }
      if ((localObject3 == null) || (!((QQUserUIItem)localObject3).isVip())) {
        break label252;
      }
      bool = true;
      label141:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label257;
      }
    }
    label257:
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = ajjy.a(2131647991))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName((String)localObject1, this.jdField_a_of_type_Boolean);
      c(paramssm);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramssm.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramssm.d) });
      }
      return;
      label223:
      localObject1 = new srn("", (String)localObject2);
      new sxp().a(1, (srn)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void b(ssm paramssm)
  {
    urk.b("VASH", "My bindImage of data: %s", String.valueOf(paramssm));
    if (paramssm.jdField_b_of_type_Boolean) {
      a(paramssm, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramssm);
      return;
      if (paramssm.d > 0) {
        a(paramssm, 2);
      } else {
        a(paramssm, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svz
 * JD-Core Version:    0.7.0.1
 */