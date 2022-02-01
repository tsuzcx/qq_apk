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
import bqhs;
import bqxn;
import bqxo;
import bqxp;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import zkg;
import zkm;

public class HorizontalAlumbListLayout
  extends RelativeLayout
  implements View.OnClickListener, zkm
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bqhs a;
  private bqxp jdField_a_of_type_Bqxp;
  
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561806, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374696));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Bqxp = new bqxp(this, getContext(), this, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bqxp);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new bqxn(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374695));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bqxo(this));
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(SlideItemInfo paramSlideItemInfo) {}
  
  public void a(String paramString) {}
  
  public void a(List<SlideItemInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HorizontalAlumbListLayout", 2, "updateData size=" + paramList.size());
    }
    if ((this.jdField_a_of_type_Bqxp != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_Bqxp.a(paramList);
    }
  }
  
  public void onClick(View paramView) {}
  
  public void setEditVideoUI(bqhs parambqhs)
  {
    this.jdField_a_of_type_Bqhs = parambqhs;
  }
  
  public void setTipsContent(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    if (zkg.a().a() == 13)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getContext().getString(2131691683), new Object[] { zkg.a().a().size() + "" }));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout
 * JD-Core Version:    0.7.0.1
 */