import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

public class el
  extends et
{
  public static String a;
  ajgm jdField_a_of_type_Ajgm = null;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new em(this);
  public View.OnLongClickListener a;
  public PrinterActivity a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.PrinterSessionAdapter";
  }
  
  public el(PrinterActivity paramPrinterActivity, ajgm paramajgm)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new eo(this);
    this.jdField_a_of_type_Ajgm = paramajgm;
    this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity = paramPrinterActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramPrinterActivity);
    this.jdField_a_of_type_Ajgm.a.b();
    b();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Ajgm.a.a.size();
  }
  
  public long a(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_Ajgm.a.a.get(paramInt)).time;
  }
  
  protected boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      return true;
    }
    bakh localbakh = new bakh();
    paramView = (ed)paramView.getTag();
    Object localObject1 = (PrinterItemMsgRecord)paramView.a();
    if (localObject1 != null)
    {
      localObject2 = paramView.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localObject2 == null) {
        return false;
      }
    }
    else
    {
      return false;
    }
    Object localObject2 = ((RelativeLayout)localObject2).getContext();
    localbakh.a(2131299423, ((Context)localObject2).getString(2131628253));
    localObject1 = new ep(this, (PrinterItemMsgRecord)localObject1, (Context)localObject2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = baay.a(paramView.jdField_a_of_type_AndroidWidgetRelativeLayout, localbakh, (View.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new en(this));
    return true;
  }
  
  public long b(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_Ajgm.a.a.get(paramInt)).uniseq;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Ajgm.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Ajgm.a.a.size() > paramInt) {
      this.jdField_a_of_type_Ajgm.a.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Ajgm.a.a.size() > paramInt) {}
    for (paramViewGroup = (PrinterItemMsgRecord)this.jdField_a_of_type_Ajgm.a.a.get(paramInt);; paramViewGroup = null)
    {
      if (paramViewGroup == null) {
        return null;
      }
      ed localed;
      Object localObject;
      int i;
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493385, null);
        localed = new ed();
        localed.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131304813));
        localed.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localed);
        localed.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        localed.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
        localed.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localed.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localed.jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        localed.b((TextView)paramView.findViewById(2131310659));
        localObject = (RelativeLayout)paramView.findViewById(2131300634);
        localed.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
        localed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131300610));
        localed.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300647));
        localed.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131300622));
        localed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130849385);
        localed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localed.a((TextView)paramView.findViewById(2131299356));
        paramView.setTag(localed);
        localed.a(paramViewGroup);
        localed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localObject = apdh.a(paramViewGroup.filename);
        if (localObject != null) {
          break label641;
        }
        localed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843465);
        localObject = paramViewGroup.filename;
        i = paramViewGroup.filename.lastIndexOf("/");
        if (i >= 0) {
          localObject = apck.d(paramViewGroup.filename.substring(i + 1));
        }
        localed.a().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        switch (paramViewGroup.status)
        {
        }
      }
      for (;;)
      {
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.app))
        {
          localObject = (amyl)this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.a.getTag(2131296269);
          if (localObject != null)
          {
            i = ackc.a(((amyl)localObject).getBitmap());
            localed.a().setTextColor(ColorStateList.valueOf(i));
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("dataline.time", 4, "time[" + paramViewGroup.time + "], uniseq[" + paramViewGroup.uniseq + "], lastShowTime[" + this.jdField_a_of_type_Long + "], filename[" + paramViewGroup.filename + "], position[" + paramInt + "], mapShowTime[" + a(paramViewGroup.uniseq));
        }
        if (!a(paramViewGroup.uniseq)) {
          break label893;
        }
        paramViewGroup = baiu.a(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity, 3, paramViewGroup.time * 1000L);
        localed.a().setVisibility(0);
        localed.a().setText(paramViewGroup);
        return paramView;
        localed = (ed)paramView.getTag();
        break;
        label641:
        localed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(apck.b((String)localObject));
        switch (apck.a((String)localObject))
        {
        default: 
          i = apck.b((String)localObject);
          if (i == 0) {
            break;
          }
          localed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(i);
          break;
        case 0: 
          localed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(128, 128);
          localed.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramViewGroup.filename);
          break;
          localed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localed.b().setText(2131625794);
          continue;
          localed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localed.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramViewGroup.progress * 100.0D));
          localed.b().setText(2131625795);
          continue;
          localed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localed.b().setText(2131625797);
          continue;
          localed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localed.b().setText(2131625796);
          continue;
          localed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localed.b().setText(2131625798);
        }
      }
      label893:
      localed.a().setVisibility(8);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     el
 * JD-Core Version:    0.7.0.1
 */