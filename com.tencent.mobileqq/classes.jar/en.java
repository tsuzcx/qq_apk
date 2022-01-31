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

public class en
  extends ev
{
  public static String a;
  allz jdField_a_of_type_Allz = null;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eo(this);
  public View.OnLongClickListener a;
  public PrinterActivity a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.PrinterSessionAdapter";
  }
  
  public en(PrinterActivity paramPrinterActivity, allz paramallz)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new eq(this);
    this.jdField_a_of_type_Allz = paramallz;
    this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity = paramPrinterActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramPrinterActivity);
    this.jdField_a_of_type_Allz.a.b();
    b();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Allz.a.a.size();
  }
  
  public long a(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_Allz.a.a.get(paramInt)).time;
  }
  
  protected boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      return true;
    }
    bdkz localbdkz = new bdkz();
    paramView = (ef)paramView.getTag();
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
    localbdkz.a(2131365075, ((Context)localObject2).getString(2131694011));
    localObject1 = new er(this, (PrinterItemMsgRecord)localObject1, (Context)localObject2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdbk.a(paramView.jdField_a_of_type_AndroidWidgetRelativeLayout, localbdkz, (View.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ep(this));
    return true;
  }
  
  public long b(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_Allz.a.a.get(paramInt)).uniseq;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Allz.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Allz.a.a.size() > paramInt) {
      this.jdField_a_of_type_Allz.a.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Allz.a.a.size() > paramInt) {}
    for (paramViewGroup = (PrinterItemMsgRecord)this.jdField_a_of_type_Allz.a.a.get(paramInt);; paramViewGroup = null)
    {
      if (paramViewGroup == null) {
        return null;
      }
      ef localef;
      Object localObject;
      int i;
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558983, null);
        localef = new ef();
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370783));
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localef);
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        localef.b((TextView)paramView.findViewById(2131376954));
        localObject = (RelativeLayout)paramView.findViewById(2131366324);
        localef.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366300));
        localef.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366337));
        localef.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366312));
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130850064);
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localef.a((TextView)paramView.findViewById(2131365006));
        paramView.setTag(localef);
        localef.a(paramViewGroup);
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localObject = arof.a(paramViewGroup.filename);
        if (localObject != null) {
          break label641;
        }
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843909);
        localObject = paramViewGroup.filename;
        i = paramViewGroup.filename.lastIndexOf("/");
        if (i >= 0) {
          localObject = arni.d(paramViewGroup.filename.substring(i + 1));
        }
        localef.a().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        switch (paramViewGroup.status)
        {
        }
      }
      for (;;)
      {
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.app))
        {
          localObject = (apgf)this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.a.getTag(2131361805);
          if (localObject != null)
          {
            i = aemb.a(((apgf)localObject).getBitmap());
            localef.a().setTextColor(ColorStateList.valueOf(i));
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("dataline.time", 4, "time[" + paramViewGroup.time + "], uniseq[" + paramViewGroup.uniseq + "], lastShowTime[" + this.jdField_a_of_type_Long + "], filename[" + paramViewGroup.filename + "], position[" + paramInt + "], mapShowTime[" + a(paramViewGroup.uniseq));
        }
        if (!a(paramViewGroup.uniseq)) {
          break label893;
        }
        paramViewGroup = bdjj.a(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity, 3, paramViewGroup.time * 1000L);
        localef.a().setVisibility(0);
        localef.a().setText(paramViewGroup);
        return paramView;
        localef = (ef)paramView.getTag();
        break;
        label641:
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(arni.b((String)localObject));
        switch (arni.a((String)localObject))
        {
        default: 
          i = arni.b((String)localObject);
          if (i == 0) {
            break;
          }
          localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(i);
          break;
        case 0: 
          localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(128, 128);
          localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramViewGroup.filename);
          break;
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localef.b().setText(2131691423);
          continue;
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramViewGroup.progress * 100.0D));
          localef.b().setText(2131691424);
          continue;
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localef.b().setText(2131691426);
          continue;
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localef.b().setText(2131691425);
          continue;
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localef.b().setText(2131691427);
        }
      }
      label893:
      localef.a().setVisibility(8);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     en
 * JD-Core Version:    0.7.0.1
 */