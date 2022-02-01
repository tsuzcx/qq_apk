package dov.com.qq.im.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import bopo;
import bopw;
import bopy;
import bopz;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.model.WMLogic;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.HashMap;
import java.util.List;

public class WatermarkEditView
  extends RelativeLayout
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private DatePicker jdField_a_of_type_AndroidWidgetDatePicker;
  private bopo jdField_a_of_type_Bopo;
  private bopz jdField_a_of_type_Bopz;
  private WatermarkListView jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView;
  
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
  
  public void a()
  {
    this.jdField_a_of_type_Bopo = new bopo(this.jdField_a_of_type_AndroidAppActivity, LogicDataManager.getInstance().getEditableWMElement());
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.setAdapter(this.jdField_a_of_type_Bopo, LogicDataManager.getInstance().getEditableWMElement());
    this.jdField_a_of_type_AndroidWidgetDatePicker.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetDatePicker.init(this.jdField_a_of_type_AndroidWidgetDatePicker.getYear(), this.jdField_a_of_type_AndroidWidgetDatePicker.getMonth(), this.jdField_a_of_type_AndroidWidgetDatePicker.getDayOfMonth(), this.jdField_a_of_type_Bopo);
    this.jdField_a_of_type_Bopo.a(new bopy(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.postDelayed(new WatermarkEditView.2(this), 100L);
    setVisibility(0);
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView = ((WatermarkListView)findViewById(2131365880));
    this.jdField_a_of_type_AndroidWidgetDatePicker = ((DatePicker)findViewById(2131365283));
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    findViewById(2131378664).setOnClickListener(this);
    findViewById(2131378665).setOnClickListener(this);
  }
  
  public void b()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
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
      b();
      postDelayed(new WatermarkEditView.3(this), 200L);
      int i = 0;
      if (i < this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.a())
      {
        Object localObject = (bopw)this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.a(i);
        if (localObject == null) {}
        label374:
        for (;;)
        {
          i += 1;
          break;
          if (!CollectionUtils.indexOutOfBounds(LogicDataManager.getInstance().getEditableWMElement(), i))
          {
            WMElement localWMElement = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(i);
            if ((localWMElement.logic != null) && (localWMElement.logic.type != null) && ((localWMElement.logic.type.equals("since")) || (localWMElement.logic.type.equals("countdown"))))
            {
              if ((((bopw)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag() != null) && ((((bopw)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag() instanceof String)))
              {
                localObject = (String)((bopw)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag();
                localWMElement.userValue = ((String)localObject);
                LogicDataManager.getInstance().recordDate(localWMElement.logic.type, localWMElement.sid, (String)localObject);
              }
            }
            else if (localWMElement.ischeckin)
            {
              if (((bopw)localObject).jdField_a_of_type_Boolean)
              {
                ((bopw)localObject).jdField_a_of_type_Boolean = false;
                localWMElement.resetDays();
              }
            }
            else
            {
              localObject = StringUtils.removeUTF8Emoji(((bopw)localObject).jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim());
              if (!((String)localObject).equals(((bopo)this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.a()).a(i))) {
                localWMElement.userValue = ((String)localObject);
              }
              if (!((String)localObject).equals("")) {
                LogicDataManager.getInstance().mFollowData.put(localWMElement.id, localObject);
              }
              for (;;)
              {
                if (localWMElement.persistence != 1) {
                  break label374;
                }
                localWMElement.saveTitle((String)localObject);
                break;
                LogicDataManager.getInstance().mFollowData.put(localWMElement.id, localWMElement.getDefault());
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_Bopz != null)
      {
        this.jdField_a_of_type_Bopz.a();
        continue;
        b();
        postDelayed(new WatermarkEditView.4(this), 200L);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_AndroidWidgetDatePicker != null) && (this.jdField_a_of_type_AndroidWidgetDatePicker.getVisibility() != 0) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
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
  
  public void setOnRenderTextListener(bopz parambopz)
  {
    this.jdField_a_of_type_Bopz = parambopz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView
 * JD-Core Version:    0.7.0.1
 */