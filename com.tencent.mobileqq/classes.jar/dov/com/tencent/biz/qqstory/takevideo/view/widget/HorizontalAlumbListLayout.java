package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bmkf;
import bnaa;
import bnab;
import bnac;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import xir;
import xix;

public class HorizontalAlumbListLayout
  extends RelativeLayout
  implements View.OnClickListener, xix
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bmkf a;
  private bnac jdField_a_of_type_Bnac;
  
  public HorizontalAlumbListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public HorizontalAlumbListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561512, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373806));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Bnac = new bnac(this, getContext(), this, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bnac);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new bnaa(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373805));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bnab(this));
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(SlideItemInfo paramSlideItemInfo) {}
  
  public void a(List<SlideItemInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HorizontalAlumbListLayout", 2, "updateData size=" + paramList.size());
    }
    if ((this.jdField_a_of_type_Bnac != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_Bnac.a(paramList);
    }
  }
  
  public void c_(String paramString) {}
  
  public void onClick(View paramView) {}
  
  public void setEditVideoUI(bmkf parambmkf)
  {
    this.jdField_a_of_type_Bmkf = parambmkf;
  }
  
  public void setTipsContent(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    if (xir.a().a() == 13)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getContext().getString(2131692017), new Object[] { xir.a().a().size() + "" }));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setTipsGone()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout
 * JD-Core Version:    0.7.0.1
 */