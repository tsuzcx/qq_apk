package dov.com.qq.im.AECamera.View;

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
import bgzh;
import bgzi;
import bgzn;
import bgzv;
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
  private bgzi jdField_a_of_type_Bgzi;
  private bgzn jdField_a_of_type_Bgzn;
  private WatermarkListView jdField_a_of_type_DovComQqImAECameraViewWatermarkListView;
  
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
    this.jdField_a_of_type_Bgzn = new bgzn(this.jdField_a_of_type_AndroidAppActivity, LogicDataManager.getInstance().getEditableWMElement());
    this.jdField_a_of_type_DovComQqImAECameraViewWatermarkListView.setAdapter(this.jdField_a_of_type_Bgzn, LogicDataManager.getInstance().getEditableWMElement());
    this.jdField_a_of_type_AndroidWidgetDatePicker.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetDatePicker.init(this.jdField_a_of_type_AndroidWidgetDatePicker.getYear(), this.jdField_a_of_type_AndroidWidgetDatePicker.getMonth(), this.jdField_a_of_type_AndroidWidgetDatePicker.getDayOfMonth(), this.jdField_a_of_type_Bgzn);
    this.jdField_a_of_type_AndroidWidgetDatePicker.setCalendarViewShown(false);
    this.jdField_a_of_type_Bgzn.a(new bgzh(this));
    this.jdField_a_of_type_DovComQqImAECameraViewWatermarkListView.postDelayed(new WatermarkEditView.2(this), 100L);
    setVisibility(0);
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_DovComQqImAECameraViewWatermarkListView = ((WatermarkListView)findViewById(2131299937));
    this.jdField_a_of_type_AndroidWidgetDatePicker = ((DatePicker)findViewById(2131299351));
    this.jdField_a_of_type_AndroidWidgetDatePicker.setCalendarViewShown(false);
    this.jdField_a_of_type_DovComQqImAECameraViewWatermarkListView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    findViewById(2131311277).setOnClickListener(this);
    findViewById(2131311278).setOnClickListener(this);
  }
  
  public void b()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131311278: 
      label350:
      do
      {
        return;
        b();
        postDelayed(new WatermarkEditView.3(this), 200L);
        int i = 0;
        if (i < this.jdField_a_of_type_DovComQqImAECameraViewWatermarkListView.a())
        {
          Object localObject = (bgzv)this.jdField_a_of_type_DovComQqImAECameraViewWatermarkListView.a(i);
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            if (!CollectionUtils.indexOutOfBounds(LogicDataManager.getInstance().getEditableWMElement(), i))
            {
              paramView = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(i);
              if ((paramView.logic != null) && (paramView.logic.type != null) && ((paramView.logic.type.equals("since")) || (paramView.logic.type.equals("countdown"))))
              {
                if ((((bgzv)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag() != null) && ((((bgzv)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag() instanceof String)))
                {
                  localObject = (String)((bgzv)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag();
                  paramView.userValue = ((String)localObject);
                  LogicDataManager.getInstance().recordDate(paramView.logic.type, paramView.sid, (String)localObject);
                }
              }
              else if (paramView.ischeckin)
              {
                if (((bgzv)localObject).jdField_a_of_type_Boolean)
                {
                  ((bgzv)localObject).jdField_a_of_type_Boolean = false;
                  paramView.resetDays();
                }
              }
              else
              {
                localObject = StringUtils.removeUTF8Emoji(((bgzv)localObject).jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim());
                if (!((String)localObject).equals(((bgzn)this.jdField_a_of_type_DovComQqImAECameraViewWatermarkListView.a()).a(i))) {
                  paramView.userValue = ((String)localObject);
                }
                if (!((String)localObject).equals("")) {
                  LogicDataManager.getInstance().mFollowData.put(paramView.id, localObject);
                }
                for (;;)
                {
                  if (paramView.persistence != 1) {
                    break label350;
                  }
                  paramView.saveTitle((String)localObject);
                  break;
                  LogicDataManager.getInstance().mFollowData.put(paramView.id, paramView.getDefault());
                }
              }
            }
          }
        }
      } while (this.jdField_a_of_type_Bgzi == null);
      this.jdField_a_of_type_Bgzi.a();
      return;
    }
    b();
    postDelayed(new WatermarkEditView.4(this), 200L);
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
  
  public void setOnRenderTextListener(bgzi parambgzi)
  {
    this.jdField_a_of_type_Bgzi = parambgzi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.WatermarkEditView
 * JD-Core Version:    0.7.0.1
 */