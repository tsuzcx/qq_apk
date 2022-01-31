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
  alqo jdField_a_of_type_Alqo = null;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eo(this);
  public View.OnLongClickListener a;
  public PrinterActivity a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.PrinterSessionAdapter";
  }
  
  public en(PrinterActivity paramPrinterActivity, alqo paramalqo)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new eq(this);
    this.jdField_a_of_type_Alqo = paramalqo;
    this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity = paramPrinterActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramPrinterActivity);
    this.jdField_a_of_type_Alqo.a.b();
    b();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Alqo.a.a.size();
  }
  
  public long a(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_Alqo.a.a.get(paramInt)).time;
  }
  
  protected boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      return true;
    }
    bdpi localbdpi = new bdpi();
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
    localbdpi.a(2131365077, ((Context)localObject2).getString(2131694013));
    localObject1 = new er(this, (PrinterItemMsgRecord)localObject1, (Context)localObject2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdft.a(paramView.jdField_a_of_type_AndroidWidgetRelativeLayout, localbdpi, (View.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ep(this));
    return true;
  }
  
  public long b(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_Alqo.a.a.get(paramInt)).uniseq;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Alqo.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Alqo.a.a.size() > paramInt) {
      this.jdField_a_of_type_Alqo.a.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Alqo.a.a.size() > paramInt) {}
    for (paramViewGroup = (PrinterItemMsgRecord)this.jdField_a_of_type_Alqo.a.a.get(paramInt);; paramViewGroup = null)
    {
      if (paramViewGroup == null) {
        return null;
      }
      ef localef;
      Object localObject;
      int i;
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558982, null);
        localef = new ef();
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370802));
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localef);
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localef.jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        localef.b((TextView)paramView.findViewById(2131377008));
        localObject = (RelativeLayout)paramView.findViewById(2131366326);
        localef.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366302));
        localef.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366339));
        localef.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366314));
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130850137);
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localef.a((TextView)paramView.findViewById(2131365008));
        paramView.setTag(localef);
        localef.a(paramViewGroup);
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localObject = arso.a(paramViewGroup.filename);
        if (localObject != null) {
          break label641;
        }
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843981);
        localObject = paramViewGroup.filename;
        i = paramViewGroup.filename.lastIndexOf("/");
        if (i >= 0) {
          localObject = arrr.d(paramViewGroup.filename.substring(i + 1));
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
          localObject = (apko)this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.a.getTag(2131361805);
          if (localObject != null)
          {
            i = aeqq.a(((apko)localObject).getBitmap());
            localef.a().setTextColor(ColorStateList.valueOf(i));
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("dataline.time", 4, "time[" + paramViewGroup.time + "], uniseq[" + paramViewGroup.uniseq + "], lastShowTime[" + this.jdField_a_of_type_Long + "], filename[" + paramViewGroup.filename + "], position[" + paramInt + "], mapShowTime[" + a(paramViewGroup.uniseq));
        }
        if (!a(paramViewGroup.uniseq)) {
          break label893;
        }
        paramViewGroup = bdns.a(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity, 3, paramViewGroup.time * 1000L);
        localef.a().setVisibility(0);
        localef.a().setText(paramViewGroup);
        return paramView;
        localef = (ef)paramView.getTag();
        break;
        label641:
        localef.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(arrr.b((String)localObject));
        switch (arrr.a((String)localObject))
        {
        default: 
          i = arrr.b((String)localObject);
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
          localef.b().setText(2131691424);
          continue;
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramViewGroup.progress * 100.0D));
          localef.b().setText(2131691425);
          continue;
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localef.b().setText(2131691427);
          continue;
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localef.b().setText(2131691426);
          continue;
          localef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localef.b().setText(2131691428);
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