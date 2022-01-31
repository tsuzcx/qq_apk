package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bbbi;
import bjye;
import bknz;
import bkoa;
import bkob;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.List;
import vel;
import vuc;
import vui;

public class HorizontalAlumbListLayout
  extends RelativeLayout
  implements View.OnClickListener, vui
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bjye a;
  private bkob jdField_a_of_type_Bkob;
  
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561323, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373355));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Bkob = new bkob(this, getContext(), this, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bkob);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new bknz(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373354));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bkoa(this));
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("HorizontalAlumbListLayout", 2, "intent to SlideShow");
        }
        if ((this.jdField_a_of_type_Bjye != null) && (this.jdField_a_of_type_Bjye.getActivity() != null)) {
          vel.a("video_edit_new", "clk_albumbar", this.jdField_a_of_type_Bjye.getActivity().getIntent(), new String[0]);
        }
        setTipsGone();
        vuc.a().b();
        Intent localIntent = new Intent(paramContext, PhotoListActivity.class);
        if (vuc.a().a() != 13)
        {
          localIntent.putExtra("ALBUM_NAME", bbbi.l);
          localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
          if (localIntent != null)
          {
            paramContext = (EditVideoParams)((Activity)paramContext).getIntent().getParcelableExtra(EditVideoParams.class.getName());
            if (paramContext != null)
            {
              i = paramContext.a("extra_ablum_type", -1);
              localIntent.putExtra("extra_ablum_type", i);
              localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
              localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
              localIntent.putExtra("from_qqstory_slideshow", true);
              localIntent.putExtra("from_qqstory_entrance", true);
              localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
              localIntent.putExtra("report_first_exposure", true);
              localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
              localIntent.putExtra("PhotoConst.IS_FROM_EDIT", true);
              if (this.jdField_a_of_type_Bjye == null) {
                break;
              }
              this.jdField_a_of_type_Bjye.getActivity().startActivityForResult(localIntent, 10018);
              this.jdField_a_of_type_Bjye.getActivity().overridePendingTransition(2130771992, 2130771993);
            }
          }
        }
        else
        {
          localIntent.putExtra("from_qqstory_custom_data", true);
          List localList = vuc.a().b();
          if (localList.size() > 0) {
            localIntent.putExtra("ALBUM_NAME", ((LocalMediaInfo)localList.get(0)).mAlbumName);
          }
          localIntent.putExtra("ALBUM_ID", "$CustomAlbumId");
          continue;
        }
        int i = -1;
      }
      catch (Exception paramContext)
      {
        return;
      }
    }
  }
  
  public void a(SlideItemInfo paramSlideItemInfo) {}
  
  public void a(String paramString) {}
  
  public void a(List<SlideItemInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HorizontalAlumbListLayout", 2, "updateData size=" + paramList.size());
    }
    if ((this.jdField_a_of_type_Bkob != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_Bkob.a(paramList);
    }
  }
  
  public void onClick(View paramView)
  {
    a(paramView.getContext());
  }
  
  public void setEditVideoUI(bjye parambjye)
  {
    this.jdField_a_of_type_Bjye = parambjye;
  }
  
  public void setTipsContent(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    if (vuc.a().a() == 13)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getContext().getString(2131691962), new Object[] { vuc.a().a().size() + "" }));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout
 * JD-Core Version:    0.7.0.1
 */