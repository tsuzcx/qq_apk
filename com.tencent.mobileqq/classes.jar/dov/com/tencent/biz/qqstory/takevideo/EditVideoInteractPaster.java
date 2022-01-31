package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.PollWidgetUtils;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.QuestionElement;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement;
import com.tencent.biz.qqstory.view.widget.RateWidget;
import com.tribe.async.async.JobSegment;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.interact.EditVideoInteract;
import dov.com.tencent.biz.qqstory.takevideo.interact.InteractPasterItem.InteractPasterInfo;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.Publishable;

public class EditVideoInteractPaster
  extends EditVideoPart
  implements View.OnClickListener, EditInteractPasterExport, Publishable
{
  private int jdField_a_of_type_Int = 1000;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PollWidgetUtils.IPollWidget jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget;
  private RateWidget jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget;
  private EditVideoVote jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote;
  private EditVideoInteract jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract;
  private int jdField_b_of_type_Int = 1000;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public EditVideoInteractPaster(@NonNull EditVideoPartManager paramEditVideoPartManager, @NonNull EditVideoVote paramEditVideoVote, EditVideoInteract paramEditVideoInteract)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote = paramEditVideoVote;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract = paramEditVideoInteract;
  }
  
  private Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    VoteLayer.VoteItem localVoteItem = null;
    if (paramInt == 1000) {
      localVoteItem = a().a;
    }
    while (localVoteItem != null)
    {
      EditVideoVote.a(localBundle, localVoteItem);
      return localBundle;
      if (paramInt == 1001) {
        localVoteItem = a().a;
      }
    }
    localBundle.putFloat("scale", 1.0F);
    localBundle.putFloat("rotate", 0.0F);
    localBundle.putFloat("translateX", 0.0F);
    localBundle.putFloat("translateY", 0.0F);
    return localBundle;
  }
  
  @NonNull
  private EditInteractExport a()
  {
    EditInteractExport localEditInteractExport = (EditInteractExport)a(EditInteractExport.class);
    if (localEditInteractExport == null) {
      throw new IllegalStateException("not support interact paster.");
    }
    return localEditInteractExport;
  }
  
  @NonNull
  private EditVoteExport a()
  {
    EditVoteExport localEditVoteExport = (EditVoteExport)a(EditVoteExport.class);
    if (localEditVoteExport == null) {
      throw new IllegalStateException("not support vote.");
    }
    return localEditVoteExport;
  }
  
  @NonNull
  private InteractPasterLayer a()
  {
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)a(EditDoodleExport.class);
    if (localEditDoodleExport == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localEditDoodleExport.a().a();
  }
  
  @NonNull
  private VoteLayer a()
  {
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)a(EditDoodleExport.class);
    if (localEditDoodleExport == null) {
      throw new IllegalStateException("not support doodle.");
    }
    return localEditDoodleExport.a().a();
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1000)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget = PollWidgetUtils.a(a(), 0, 0, null);
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(false);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = a().a();
      if (localObject != null)
      {
        arrayOfWidgetElement = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
        paramInt = 0;
        while (paramInt < arrayOfWidgetElement.length)
        {
          arrayOfWidgetElement[paramInt].a(localObject.a[paramInt]);
          paramInt += 1;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a().a());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a());
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.d(true);
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.d(false);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841766);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      }
    }
    while (paramInt != 1001) {
      for (;;)
      {
        PollWidgetUtils.WidgetElement[] arrayOfWidgetElement;
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a().b("向好友提问...");
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setHint("向好友提问...");
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget = new RateWidget(a());
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.b(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(0.0F);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = a().a();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(((InteractPasterItem.InteractPasterInfo)localObject).a);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localObject.a[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a());
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.d(true);
      if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.d(false);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130841766);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setHint("让好友评分...");
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      localObject = a();
      if (((VoteLayer)localObject).a != null)
      {
        if (!paramBoolean) {
          break label28;
        }
        ((VoteLayer)localObject).d();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        ((VoteLayer)localObject).c();
        return;
      } while (paramInt != 1001);
      localObject = a();
    } while (((InteractPasterLayer)localObject).a == null);
    if (paramBoolean)
    {
      ((InteractPasterLayer)localObject).d();
      return;
    }
    ((InteractPasterLayer)localObject).c();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371665));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371662));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371663));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363479));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371664).setOnClickListener(this);
    }
  }
  
  public JobSegment a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return null;
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract.a(paramInt);
    }
    throw new IllegalStateException("getPublishSegment, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131364331));
    a(EditInteractPasterExport.class, this);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if (this.jdField_a_of_type_Int == 1000)
    {
      a().b(paramInt, paramGenerateContext);
      return;
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      a().a_(paramInt, paramGenerateContext);
      return;
    }
    throw new IllegalStateException("editVideoPrePublish, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      return;
      c();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(this.jdField_a_of_type_Int, false);
      a(this.jdField_a_of_type_Int);
      return;
      a(this.jdField_a_of_type_Int, true);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 1000) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote.b();
    }
    if (this.jdField_a_of_type_Int == 1001) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract.b();
    }
    throw new IllegalStateException("checkInteractPasterInfoEmpty, unKnown type:" + this.jdField_a_of_type_Int);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371662: 
      this.jdField_b_of_type_Int = 1000;
      a(1000);
      return;
    case 2131371663: 
      this.jdField_b_of_type_Int = 1001;
      a(1001);
      return;
    case 2131363479: 
      paramView = a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      if (this.jdField_b_of_type_Int == 1000)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(35, paramView);
        return;
      }
      paramView.putInt("interact_type", this.jdField_b_of_type_Int);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(38, paramView);
      return;
    }
    if (this.jdField_b_of_type_Int == 1000)
    {
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
      int j = paramView.length;
      int i = 0;
      while (i < j)
      {
        paramView[i].a(false);
        i += 1;
      }
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
      PollWidgetUtils.WidgetElement[] arrayOfWidgetElement = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
      Rect[] arrayOfRect = new Rect[arrayOfWidgetElement.length];
      String[] arrayOfString = new String[arrayOfWidgetElement.length];
      i = 0;
      while (i < arrayOfWidgetElement.length)
      {
        arrayOfRect[i] = arrayOfWidgetElement[i].a();
        arrayOfString[i] = arrayOfWidgetElement[i].a().toString();
        i += 1;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoVote.a(a(this.jdField_a_of_type_Int), arrayOfString, paramView, arrayOfRect, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return;
      if (this.jdField_b_of_type_Int == 1001)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.c(false);
        paramView = a(this.jdField_a_of_type_Int);
        paramView.putInt("interact_type", 1001);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract.a(paramView, new InteractPasterItem.InteractPasterInfo(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(), this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(), this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget.a(), false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoInteractPaster
 * JD-Core Version:    0.7.0.1
 */