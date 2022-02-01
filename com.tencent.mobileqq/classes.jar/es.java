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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

public class es
  extends fa
{
  public static String a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new et(this);
  public View.OnLongClickListener a;
  anjx jdField_a_of_type_Anjx = null;
  public PrinterActivity a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.PrinterSessionAdapter";
  }
  
  public es(PrinterActivity paramPrinterActivity, anjx paramanjx)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new ev(this);
    this.jdField_a_of_type_Anjx = paramanjx;
    this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity = paramPrinterActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramPrinterActivity);
    this.jdField_a_of_type_Anjx.a.b();
    b();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Anjx.a.a.size();
  }
  
  public long a(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_Anjx.a.a.get(paramInt)).time;
  }
  
  protected boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      return true;
    }
    bguh localbguh = new bguh();
    paramView = (ek)paramView.getTag();
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
    localbguh.a(2131365314, ((Context)localObject2).getString(2131693309));
    localObject1 = new ew(this, (PrinterItemMsgRecord)localObject1, (Context)localObject2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bgkw.a(paramView.jdField_a_of_type_AndroidWidgetRelativeLayout, localbguh, (View.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new eu(this));
    return true;
  }
  
  public long b(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_Anjx.a.a.get(paramInt)).uniseq;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Anjx.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Anjx.a.a.size() > paramInt) {
      this.jdField_a_of_type_Anjx.a.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Anjx.a.a.size() > paramInt) {}
    for (Object localObject1 = (PrinterItemMsgRecord)this.jdField_a_of_type_Anjx.a.a.get(paramInt);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 == null)
      {
        localObject2 = null;
        localObject1 = paramView;
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject2;
      }
      Object localObject3;
      label295:
      int i;
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559050, null);
        localObject2 = new ek();
        ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371363));
        ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
        ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
        ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ek)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((ek)localObject2).b((TextView)paramView.findViewById(2131377812));
        localObject3 = (RelativeLayout)paramView.findViewById(2131366578);
        ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
        ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366556));
        ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366590));
        ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366567));
        ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130850731);
        ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ek)localObject2).a((TextView)paramView.findViewById(2131365244));
        paramView.setTag(localObject2);
        ((ek)localObject2).a(localObject1);
        ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localObject3 = atwl.a(((PrinterItemMsgRecord)localObject1).filename);
        if (localObject3 != null) {
          break label688;
        }
        ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844375);
        localObject3 = ((PrinterItemMsgRecord)localObject1).filename;
        i = ((PrinterItemMsgRecord)localObject1).filename.lastIndexOf("/");
        if (i >= 0) {
          localObject3 = atvo.d(((PrinterItemMsgRecord)localObject1).filename.substring(i + 1));
        }
        ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        switch (((PrinterItemMsgRecord)localObject1).status)
        {
        default: 
          label452:
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.app))
          {
            localObject3 = (arni)this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.a.getTag(2131361806);
            if (localObject3 != null)
            {
              i = afxa.a(((arni)localObject3).getBitmap());
              ((ek)localObject2).a().setTextColor(ColorStateList.valueOf(i));
            }
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("dataline.time", 4, "time[" + ((PrinterItemMsgRecord)localObject1).time + "], uniseq[" + ((PrinterItemMsgRecord)localObject1).uniseq + "], lastShowTime[" + this.jdField_a_of_type_Long + "], filename[" + ((PrinterItemMsgRecord)localObject1).filename + "], position[" + paramInt + "], mapShowTime[" + a(((PrinterItemMsgRecord)localObject1).uniseq));
          }
          if (a(((PrinterItemMsgRecord)localObject1).uniseq))
          {
            localObject1 = bgsu.a(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity, 3, ((PrinterItemMsgRecord)localObject1).time * 1000L);
            ((ek)localObject2).a().setVisibility(0);
            ((ek)localObject2).a().setText((CharSequence)localObject1);
          }
          break;
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        localObject2 = paramView;
        break;
        localObject2 = (ek)paramView.getTag();
        break label295;
        label688:
        ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(atvo.b((String)localObject3));
        switch (atvo.a((String)localObject3))
        {
        default: 
          i = atvo.b((String)localObject3);
          if (i == 0) {
            break;
          }
          ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(i);
          break;
        case 0: 
          ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(128, 128);
          ((ek)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(((PrinterItemMsgRecord)localObject1).filename);
          break;
          ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((ek)localObject2).b().setText(2131691204);
          break label452;
          ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((PrinterItemMsgRecord)localObject1).progress * 100.0D));
          ((ek)localObject2).b().setText(2131691205);
          break label452;
          ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          ((ek)localObject2).b().setText(2131691207);
          break label452;
          ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          ((ek)localObject2).b().setText(2131691206);
          break label452;
          ((ek)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          ((ek)localObject2).b().setText(2131691208);
          break label452;
          ((ek)localObject2).a().setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     es
 * JD-Core Version:    0.7.0.1
 */