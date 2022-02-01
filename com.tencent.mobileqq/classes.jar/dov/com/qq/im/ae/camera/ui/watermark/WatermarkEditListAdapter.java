package dov.com.qq.im.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.util.AEQLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.light.bean.WMElement;

public class WatermarkEditListAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements DatePicker.OnDateChangedListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WatermarkEditListAdapter.OnDateItemClickedListener jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener;
  private final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
  private final List<WMElement> jdField_a_of_type_JavaUtilList;
  private WMElement jdField_a_of_type_OrgLightBeanWMElement;
  private boolean jdField_a_of_type_Boolean = true;
  
  public WatermarkEditListAdapter(Activity paramActivity, List<WMElement> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private String a(WMElement paramWMElement)
  {
    if (paramWMElement == null) {
      return null;
    }
    String str = paramWMElement.getInnerValue();
    if (("SINCE".equals(paramWMElement.type)) || ("COUNTDOWN".equals(paramWMElement.type)))
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(str);
        l1 = l2;
      }
      catch (NumberFormatException paramWMElement)
      {
        for (;;)
        {
          AEQLog.a("WatermarkEditListAdapter", "getDisplayText---parseLong error: ", paramWMElement);
        }
      }
      return this.jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l1));
    }
    return str;
  }
  
  private Date a(String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        AEQLog.a("WatermarkEditListAdapter", "parseToDate---parseLong error: ", paramString);
      }
    }
    return new Date(l1);
  }
  
  private void a(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.postDelayed(new WatermarkEditListAdapter.8(this, paramEditText), 200L);
    }
  }
  
  private void a(EditText paramEditText, WMElement paramWMElement)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_OrgLightBeanWMElement = paramWMElement;
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener.a();
    }
  }
  
  private void a(WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidWidgetEditText.getContext(), 2131755842);
    localQQCustomDialog.setContentView(2131559084);
    localQQCustomDialog.setTitle(HardCodeUtil.a(2131716702));
    localQQCustomDialog.setMessage(HardCodeUtil.a(2131716707));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131716703), new WatermarkEditListAdapter.6(this));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131716704), new WatermarkEditListAdapter.7(this, paramEditTextViewHolder));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  private void b(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setCustomSelectionActionModeCallback(new WatermarkEditListAdapter.9(this));
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_OrgLightBeanWMElement != null))
    {
      if ((!"SINCE".equals(this.jdField_a_of_type_OrgLightBeanWMElement.type)) && (!"COUNTDOWN".equals(this.jdField_a_of_type_OrgLightBeanWMElement.type))) {
        break label145;
      }
      if (!AECameraEntry.k(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {
        break label123;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165273));
      if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener != null) {
        this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener.a(a(this.jdField_a_of_type_OrgLightBeanWMElement.getInnerValue()));
      }
    }
    label123:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165274));
        break;
      } while (!"PLAIN_TEXT".equals(this.jdField_a_of_type_OrgLightBeanWMElement.type));
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
      ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 1);
    } while (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener == null);
    label145:
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener.a();
  }
  
  public void a(WatermarkEditListAdapter.OnDateItemClickedListener paramOnDateItemClickedListener)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$OnDateItemClickedListener = paramOnDateItemClickedListener;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    WMElement localWMElement = (WMElement)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localWMElement == null) {}
    WatermarkEditListAdapter.EditTextViewHolder localEditTextViewHolder;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        localEditTextViewHolder = (WatermarkEditListAdapter.EditTextViewHolder)paramViewHolder;
        if (paramInt == 0)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidWidgetEditText = localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText;
            this.jdField_a_of_type_OrgLightBeanWMElement = localWMElement;
          }
          if (getItemCount() == 1) {
            localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
          }
        }
        if (paramInt == getItemCount() - 1) {
          localEditTextViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        localEditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new WatermarkEditListAdapter.1(this, localWMElement, localEditTextViewHolder));
        if ("EDITABLE_LOCATION".equals(localWMElement.type))
        {
          localEditTextViewHolder.b.setVisibility(8);
          localEditTextViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView = localEditTextViewHolder.jdField_a_of_type_AndroidWidgetTextView;
          if (localEditTextViewHolder.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localEditTextViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(localWMElement));
            localEditTextViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(new WatermarkEditListAdapter.2(this));
          }
        }
        else
        {
          if ((!"SINCE".equals(localWMElement.type)) && (!"COUNTDOWN".equals(localWMElement.type))) {
            break;
          }
          localEditTextViewHolder.b.setVisibility(0);
          localEditTextViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
          localEditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
          localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setText(a(localWMElement));
          localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
          localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new WatermarkEditListAdapter.3(this, localEditTextViewHolder, localWMElement));
          b(localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText);
        }
      }
    } while ((!"CHECK_IN".equals(localWMElement.type)) && (!"PLAIN_TEXT".equals(localWMElement.type)));
    localEditTextViewHolder.b.setVisibility(0);
    localEditTextViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setText(a(localWMElement));
    if ("CHECK_IN".equals(localWMElement.type))
    {
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837720);
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new WatermarkEditListAdapter.4(this, localEditTextViewHolder, localWMElement));
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new WatermarkEditListAdapter.5(this, localEditTextViewHolder, localWMElement));
      break;
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837718);
      localEditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new WatermarkEditListAdapter.EditTextViewHolder(this, LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558519, paramViewGroup, false));
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_OrgLightBeanWMElement != null))
    {
      localStringBuilder = new StringBuilder().append(paramInt1).append(HardCodeUtil.a(2131716706));
      if (paramInt2 + 1 >= 10) {
        break label138;
      }
      paramDatePicker = "0";
      localStringBuilder = localStringBuilder.append(paramDatePicker).append(paramInt2 + 1).append(HardCodeUtil.a(2131716701));
      if (paramInt3 >= 10) {
        break label145;
      }
    }
    label138:
    label145:
    for (paramDatePicker = "0";; paramDatePicker = "")
    {
      paramDatePicker = paramDatePicker + paramInt3 + HardCodeUtil.a(2131716705);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramDatePicker);
      paramDatePicker = Calendar.getInstance();
      paramDatePicker.set(paramInt1, paramInt2, paramInt3);
      this.jdField_a_of_type_AndroidWidgetEditText.setTag(paramDatePicker.getTime());
      return;
      paramDatePicker = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditListAdapter
 * JD-Core Version:    0.7.0.1
 */