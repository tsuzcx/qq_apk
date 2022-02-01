package dov.com.qq.im.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bnhy;
import bnih;
import bnij;
import bnik;
import bnlb;
import bnqc;
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
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private DatePicker jdField_a_of_type_AndroidWidgetDatePicker;
  private bnhy jdField_a_of_type_Bnhy;
  private bnik jdField_a_of_type_Bnik;
  protected bnqc a;
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
  
  private void c()
  {
    if ((this.jdField_a_of_type_Bnqc.a(589824)) && (((Boolean)this.jdField_a_of_type_Bnqc.a(589826, new Object[0])).booleanValue())) {
      this.jdField_a_of_type_Bnqc.a(589826, new Object[0]);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bnhy = new bnhy(this.jdField_a_of_type_AndroidAppActivity, LogicDataManager.getInstance().getEditableWMElement());
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.setAdapter(this.jdField_a_of_type_Bnhy, LogicDataManager.getInstance().getEditableWMElement());
    this.jdField_a_of_type_AndroidWidgetDatePicker.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetDatePicker.init(this.jdField_a_of_type_AndroidWidgetDatePicker.getYear(), this.jdField_a_of_type_AndroidWidgetDatePicker.getMonth(), this.jdField_a_of_type_AndroidWidgetDatePicker.getDayOfMonth(), this.jdField_a_of_type_Bnhy);
    this.jdField_a_of_type_Bnhy.a(new bnij(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.postDelayed(new WatermarkEditView.2(this), 100L);
    setVisibility(0);
  }
  
  public void a(Activity paramActivity, bnqc parambnqc)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Bnqc = parambnqc;
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView = ((WatermarkListView)findViewById(2131366010));
    this.jdField_a_of_type_AndroidWidgetDatePicker = ((DatePicker)findViewById(2131365406));
    findViewById(2131378719).setOnClickListener(this);
    parambnqc = (TextView)findViewById(2131378720);
    parambnqc.setOnClickListener(this);
    if (bnlb.j(paramActivity.getIntent()))
    {
      parambnqc.setTextColor(paramActivity.getResources().getColor(2131165269));
      return;
    }
    parambnqc.setTextColor(paramActivity.getResources().getColor(2131165270));
  }
  
  public void b()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public void onClick(View paramView)
  {
    int j;
    Object localObject;
    WMElement localWMElement;
    label274:
    int i;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131378720: 
      b();
      postDelayed(new WatermarkEditView.3(this), 200L);
      j = 0;
      if (j < this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.a())
      {
        localObject = (bnih)this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.a(j);
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          if (!CollectionUtils.indexOutOfBounds(LogicDataManager.getInstance().getEditableWMElement(), j))
          {
            localWMElement = (WMElement)LogicDataManager.getInstance().getEditableWMElement().get(j);
            if ((localWMElement.logic != null) && (localWMElement.logic.type != null) && ((localWMElement.logic.type.equals("since")) || (localWMElement.logic.type.equals("countdown"))))
            {
              if ((((bnih)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag() != null) && ((((bnih)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag() instanceof String)))
              {
                localObject = (String)((bnih)localObject).jdField_a_of_type_AndroidWidgetEditText.getTag();
                localWMElement.userValue = ((String)localObject);
                LogicDataManager.getInstance().recordDate(localWMElement.logic.type, localWMElement.sid, (String)localObject);
              }
            }
            else
            {
              if (!localWMElement.ischeckin) {
                break label274;
              }
              if (((bnih)localObject).jdField_a_of_type_Boolean)
              {
                ((bnih)localObject).jdField_a_of_type_Boolean = false;
                localWMElement.resetDays();
              }
            }
          }
        }
        if (((bnih)localObject).b.getVisibility() == 0)
        {
          localObject = ((bnih)localObject).jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
          i = 0;
        }
      }
      break;
    }
    for (;;)
    {
      label303:
      localObject = StringUtils.removeUTF8Emoji((String)localObject);
      if (!((String)localObject).equals(((bnhy)this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkListView.a()).a(j))) {
        localWMElement.userValue = ((String)localObject);
      }
      if (!((String)localObject).equals(""))
      {
        if (i != 0)
        {
          LogicDataManager.getInstance().setLocation((String)localObject);
          LogicDataManager.getInstance().recordLocationForSpecificMaterial(localWMElement.sid, (String)localObject);
        }
        LogicDataManager.getInstance().mFollowData.put(localWMElement.id, localObject);
      }
      while (localWMElement.persistence == 1)
      {
        localWMElement.saveTitle((String)localObject);
        break;
        if (((bnih)localObject).jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
          break label518;
        }
        localObject = ((bnih)localObject).jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim();
        i = 1;
        break label303;
        LogicDataManager.getInstance().mFollowData.put(localWMElement.id, localWMElement.getDefault());
      }
      if (this.jdField_a_of_type_Bnik != null) {
        this.jdField_a_of_type_Bnik.a();
      }
      c();
      break;
      b();
      postDelayed(new WatermarkEditView.4(this), 200L);
      c();
      break;
      label518:
      localObject = null;
      i = 0;
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
  
  public void setOnRenderTextListener(bnik parambnik)
  {
    this.jdField_a_of_type_Bnik = parambnik;
  }
  
  public void setWaterMarkLocation(String paramString)
  {
    if (this.jdField_a_of_type_Bnhy != null) {
      this.jdField_a_of_type_Bnhy.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView
 * JD-Core Version:    0.7.0.1
 */