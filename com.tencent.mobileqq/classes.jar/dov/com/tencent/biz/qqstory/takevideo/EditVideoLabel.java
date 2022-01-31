package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import aocp;
import aocq;
import aocr;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import dov.com.tencent.biz.qqstory.takevideo.label.QQStoryAddVideoLabelViewPart;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public class EditVideoLabel
  extends EditVideoPart
  implements View.OnClickListener
{
  protected ViewStub a;
  public TextView a;
  public QQStoryAddVideoLabelViewPart a;
  public String a;
  
  public EditVideoLabel(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void c()
  {
    k();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a() != 0)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a.requestFocus();
      InputMethodUtil.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a);
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a() == 0))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a(4);
      InputMethodUtil.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a.clearFocus();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart == null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart = new QQStoryAddVideoLabelViewPart(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a(new aocq(this));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.b(new aocr(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131364447));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new aocp(this));
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    paramGenerateContext.a.videoLabel = a();
    EditVideoPartManager localEditVideoPartManager;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localEditVideoPartManager = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
        str = a();
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramGenerateContext = "2";; paramGenerateContext = "1")
    {
      localEditVideoPartManager.a("pub_tag", 0, 0, new String[] { "1", str, paramGenerateContext });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a() == 0)
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
    default: 
      i();
      return;
    case 0: 
      i();
      return;
    }
    c();
  }
  
  public void h() {}
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoLabel
 * JD-Core Version:    0.7.0.1
 */