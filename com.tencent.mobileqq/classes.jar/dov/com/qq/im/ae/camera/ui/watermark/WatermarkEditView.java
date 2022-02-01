package dov.com.qq.im.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.string.StringUtils;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import java.util.Date;
import java.util.List;
import org.light.bean.WMElement;

public class WatermarkEditView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private DatePicker jdField_a_of_type_AndroidWidgetDatePicker;
  private WatermarkEditListAdapter jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter;
  private WatermarkEditView.OnRendorTextListener jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView$OnRendorTextListener;
  private WatermarkListView jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView;
  protected VideoStoryCapturePartManager a;
  private List<WMElement> jdField_a_of_type_JavaUtilList;
  
  public WatermarkEditView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WatermarkEditView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WatermarkEditView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(589824)) && (((Boolean)this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(589826, new Object[0])).booleanValue())) {
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(589826, new Object[0]);
    }
  }
  
  public void a()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public void a(Activity paramActivity, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager = paramVideoStoryCapturePartManager;
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView = ((WatermarkListView)findViewById(2131366175));
    this.jdField_a_of_type_AndroidWidgetDatePicker = ((DatePicker)findViewById(2131365570));
    findViewById(2131379151).setOnClickListener(this);
    paramVideoStoryCapturePartManager = (TextView)findViewById(2131379152);
    paramVideoStoryCapturePartManager.setOnClickListener(this);
    if (AECameraEntry.k(paramActivity.getIntent()))
    {
      paramVideoStoryCapturePartManager.setTextColor(paramActivity.getResources().getColor(2131165273));
      return;
    }
    paramVideoStoryCapturePartManager.setTextColor(paramActivity.getResources().getColor(2131165274));
  }
  
  public void a(List<WMElement> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter = new WatermarkEditListAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter);
    this.jdField_a_of_type_AndroidWidgetDatePicker.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetDatePicker.init(this.jdField_a_of_type_AndroidWidgetDatePicker.getYear(), this.jdField_a_of_type_AndroidWidgetDatePicker.getMonth(), this.jdField_a_of_type_AndroidWidgetDatePicker.getDayOfMonth(), this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter);
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter.a(new WatermarkEditView.1(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.postDelayed(new WatermarkEditView.2(this), 100L);
    setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      postDelayed(new WatermarkEditView.3(this), 200L);
      int i = 0;
      if (i < this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.a())
      {
        Object localObject = (WatermarkEditListAdapter.EditTextViewHolder)this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.a(i);
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (!CollectionUtils.indexOutOfBounds(this.jdField_a_of_type_JavaUtilList, i))
          {
            WMElement localWMElement = (WMElement)this.jdField_a_of_type_JavaUtilList.get(i);
            if (localWMElement != null) {
              if (("SINCE".equals(localWMElement.type)) || ("COUNTDOWN".equals(localWMElement.type)))
              {
                if ((((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag() != null) && ((((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag() instanceof Date))) {
                  localWMElement.setDate(((Date)((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag()).getTime());
                }
              }
              else if ("CHECK_IN".equals(localWMElement.type))
              {
                if (((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_Boolean)
                {
                  ((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_Boolean = false;
                  localWMElement.resetCheckIn();
                }
              }
              else if ("EDITABLE_LOCATION".equals(localWMElement.type))
              {
                localObject = StringUtils.removeUTF8Emoji(((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim());
                if (!TextUtils.isEmpty((CharSequence)localObject)) {
                  localWMElement.setLocation((String)localObject);
                }
              }
              else
              {
                localWMElement.setText(StringUtils.removeUTF8Emoji(((WatermarkEditListAdapter.EditTextViewHolder)localObject).jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()));
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView$OnRendorTextListener != null) {
        this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView$OnRendorTextListener.a();
      }
      b();
      continue;
      a();
      postDelayed(new WatermarkEditView.4(this), 200L);
      b();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setActionBarHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOnRenderTextListener(WatermarkEditView.OnRendorTextListener paramOnRendorTextListener)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView$OnRendorTextListener = paramOnRendorTextListener;
  }
  
  public void setWaterMarkLocation(String paramString)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView
 * JD-Core Version:    0.7.0.1
 */