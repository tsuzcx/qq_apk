import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.widget.XPanelContainer;

public class dx
  extends dr
{
  private View.OnClickListener b = new dy(this);
  private View.OnClickListener c = new dz(this);
  
  public dx(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramDataLineMsgSetList, paramLiteActivity, paramQQAppInterface);
  }
  
  private void a(View paramView, ed paramed)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131305604);
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2130838098);
    localImageView.setId(2131298571);
    paramed.a().jdField_a_of_type_AndroidWidgetImageView = localImageView;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramView.addView(localImageView, localLayoutParams);
    localImageView.setVisibility(8);
    localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2130838093);
    localImageView.setId(2131298558);
    paramed.a().jdField_b_of_type_AndroidWidgetImageView = localImageView;
    paramed = new RelativeLayout.LayoutParams(-2, -2);
    paramed.addRule(13);
    paramView.addView(localImageView, paramed);
    localImageView.setVisibility(8);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, ed paramed)
  {
    String str = "";
    if (paramDataLineMsgRecord.isSendFromLocal()) {
      if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc)) {
        str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626873);
      }
    }
    while (!TextUtils.isEmpty(str))
    {
      paramed.a().c.setVisibility(0);
      paramed.a().c.setText(str);
      return;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L) {
        str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131628297);
      } else if (paramDataLineMsgRecord.bIsTransfering) {
        str = "";
      } else if (!paramDataLineMsgRecord.issuc) {
        if ((paramDataLineMsgRecord.bIsSended) || (paramDataLineMsgRecord.nOpType == 1))
        {
          str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626871);
        }
        else
        {
          str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626872);
          continue;
          if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc)) {
            str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626865);
          } else if (paramDataLineMsgRecord.fileMsgStatus == 2L) {
            str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131628297);
          } else if (paramDataLineMsgRecord.bIsTransfering) {
            str = "";
          } else if (!paramDataLineMsgRecord.issuc) {
            str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626871);
          }
        }
      }
    }
    paramed.a().c.setVisibility(8);
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet, ed paramed)
  {
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      paramed.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848708);
      return;
    }
    paramed.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848515);
  }
  
  private boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) && (apdh.a(paramDataLineMsgRecord.path));
  }
  
  private void b(View paramView, ed paramed)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131305604);
    CircleFileStateView localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
    localCircleFileStateView.setId(2131298556);
    localCircleFileStateView.setProgressRingWidth(0.0F);
    localCircleFileStateView.setCenterBgColor(-1);
    localCircleFileStateView.setState(2);
    paramed.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = localCircleFileStateView;
    int i = aciy.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramView.addView(localCircleFileStateView, new RelativeLayout.LayoutParams(i, i));
    localCircleFileStateView.setVisibility(4);
    localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
    localCircleFileStateView.setId(2131298557);
    localCircleFileStateView.setProgressRingWidth(0.0F);
    localCircleFileStateView.setCenterBgColor(-1);
    localCircleFileStateView.setState(1);
    paramed.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView = localCircleFileStateView;
    paramView.addView(localCircleFileStateView, new RelativeLayout.LayoutParams(i, i));
    localCircleFileStateView.setVisibility(4);
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord, ed paramed)
  {
    if ((paramDataLineMsgRecord.progress == 1.0F) || (!paramDataLineMsgRecord.issuc) || (paramDataLineMsgRecord.fileMsgStatus == 1L) || (paramDataLineMsgRecord.fileMsgStatus == 2L))
    {
      paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      i = aciy.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = aciy.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramed.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, i);
        return;
      }
      paramed.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, i);
      return;
    }
    int i = (int)(paramDataLineMsgRecord.progress * 100.0F);
    paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
    paramed.a().jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131626906) + i);
    i = aciy.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aciy.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramed.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, 0);
      return;
    }
    paramed.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, 0);
  }
  
  private void c(DataLineMsgRecord paramDataLineMsgRecord, ed paramed)
  {
    ImageView localImageView1 = paramed.a().jdField_a_of_type_AndroidWidgetImageView;
    ImageView localImageView2 = paramed.a().jdField_b_of_type_AndroidWidgetImageView;
    if ((localImageView1 == null) || (localImageView2 == null)) {
      return;
    }
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
    }
    for (;;)
    {
      localImageView1.setTag(paramed);
      localImageView2.setTag(paramed);
      localImageView1.setOnClickListener(this.b);
      localImageView2.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(0);
      }
      else if (paramDataLineMsgRecord.bIsTransfering)
      {
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
      }
      else if (!paramDataLineMsgRecord.issuc)
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(0);
      }
      else
      {
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
      }
    }
  }
  
  private void c(ed paramed, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramed == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    Object localObject = paramDataLineMsgSet.filename;
    long l = paramDataLineMsgSet.filesize;
    a(paramed.a().jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramDataLineMsgSet);
    paramed.a().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    paramed.a().jdField_b_of_type_AndroidWidgetTextView.setText(apdh.a(l, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    b(paramDataLineMsgSet, paramed);
    a(paramDataLineMsgSet, paramed);
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      localObject = paramed.a().jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = paramed.a().jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = paramed.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      if (localObject != null) {
        ((CircleFileStateView)localObject).setVisibility(8);
      }
      localObject = paramed.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      if (localObject != null) {
        ((CircleFileStateView)localObject).setVisibility(8);
      }
      if ((paramDataLineMsgSet.bIsSended) || (paramDataLineMsgSet.nOpType == 1)) {
        d(paramDataLineMsgSet, paramed);
      }
    }
    for (;;)
    {
      e(paramDataLineMsgSet, paramed);
      return;
      c(paramDataLineMsgSet, paramed);
      continue;
      d(paramDataLineMsgSet, paramed);
    }
  }
  
  private void d(DataLineMsgRecord paramDataLineMsgRecord, ed paramed)
  {
    CircleFileStateView localCircleFileStateView1 = paramed.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
    CircleFileStateView localCircleFileStateView2 = paramed.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView;
    if ((localCircleFileStateView1 == null) || (localCircleFileStateView2 == null)) {
      return;
    }
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc))
    {
      localCircleFileStateView1.setVisibility(8);
      localCircleFileStateView2.setVisibility(8);
    }
    for (;;)
    {
      localCircleFileStateView1.setTag(paramed);
      localCircleFileStateView2.setTag(paramed);
      localCircleFileStateView1.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      localCircleFileStateView2.setOnClickListener(this.c);
      return;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else if (paramDataLineMsgRecord.fileMsgStatus == 1L)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else if (paramDataLineMsgRecord.bIsTransfering)
      {
        localCircleFileStateView1.setVisibility(8);
        localCircleFileStateView2.setVisibility(0);
      }
      else if (!paramDataLineMsgRecord.issuc)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else
      {
        localCircleFileStateView1.setVisibility(8);
        localCircleFileStateView2.setVisibility(0);
      }
    }
  }
  
  private void e(DataLineMsgRecord paramDataLineMsgRecord, ed paramed)
  {
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc) && (!a(paramDataLineMsgRecord)))
    {
      CircleFileStateView localCircleFileStateView1 = paramed.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      CircleFileStateView localCircleFileStateView2 = paramed.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      localCircleFileStateView1.setVisibility(0);
      localCircleFileStateView1.setState(2);
      localCircleFileStateView2.setVisibility(8);
      if (!paramDataLineMsgRecord.isSendFromLocal()) {
        paramed.a().c.setVisibility(8);
      }
      localCircleFileStateView1.setTag(paramed);
      localCircleFileStateView2.setTag(paramed);
      localCircleFileStateView1.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      localCircleFileStateView2.setOnClickListener(this.c);
    }
  }
  
  protected View a(int paramInt, ed paramed, DataLineMsgSet paramDataLineMsgSet)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int i;
    if (paramInt == 17)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493380, null);
      localObject3 = (ImageView)((View)localObject1).findViewById(2131302061);
      localObject2 = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843326);
      i = DataLineMsgRecord.getDevTypeBySet(paramDataLineMsgSet);
      if (i == 0)
      {
        paramDataLineMsgSet = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843326);
        ((ImageView)localObject3).setImageDrawable(paramDataLineMsgSet);
      }
    }
    for (paramDataLineMsgSet = (DataLineMsgSet)localObject1;; paramDataLineMsgSet = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493381, null))
    {
      paramed.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramDataLineMsgSet.findViewById(2131304813));
      paramed.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramed);
      paramed.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      paramed.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
      paramed.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramed.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      paramed.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramed.jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
      paramed.a((TextView)paramDataLineMsgSet.findViewById(2131299356));
      i = aciy.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131298552);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
      ((RelativeLayout)localObject1).setPadding(((Resources)localObject2).getDimensionPixelSize(2131165216), ((Resources)localObject2).getDimensionPixelSize(2131165218), ((Resources)localObject2).getDimensionPixelSize(2131165215), ((Resources)localObject2).getDimensionPixelSize(2131165217));
      localObject3 = new RelativeLayout.LayoutParams(BaseChatItemLayout.y, -2);
      int k = ((Resources)localObject2).getDimensionPixelSize(2131167688);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131302061);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject2).setMinimumHeight(aciy.a(76.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout)localObject2).setOrientation(1);
      localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10, 2131298552);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject3).setId(2131300634);
      Object localObject4 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject3).setPadding(i, i, i, 0);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramed.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
      k = aciy.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject4 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      ((AsyncImageView)localObject4).setWidth(k);
      ((AsyncImageView)localObject4).setHeight(k);
      ((AsyncImageView)localObject4).setId(2131298521);
      ((AsyncImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramed.a().jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject4);
      localObject4 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
      ((TextView)localObject4).setId(2131298523);
      ((TextView)localObject4).setGravity(48);
      ((TextView)localObject4).setIncludeFontPadding(false);
      ((TextView)localObject4).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject4).setTextSize(1, 17.0F);
      ((TextView)localObject4).setMaxLines(2);
      ((TextView)localObject4).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131298521);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramed.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131298520);
      ((TextView)localObject4).setSingleLine();
      if (befo.e()) {
        ((TextView)localObject4).setAlpha(0.75F);
      }
      ((TextView)localObject4).setGravity(17);
      ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject4).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131298523);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramed.a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131298525);
      ((TextView)localObject4).setSingleLine();
      if (befo.e()) {
        ((TextView)localObject4).setAlpha(0.75F);
      }
      ((TextView)localObject4).setGravity(17);
      ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject4).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131298520);
      localLayoutParams.addRule(8, 2131298520);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramed.a().c = ((TextView)localObject4);
      localObject3 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
      ((ProgressBar)localObject3).setId(2131298524);
      ((ProgressBar)localObject3).setMax(100);
      ((ProgressBar)localObject3).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837717));
      localObject4 = new LinearLayout.LayoutParams(-1, aciy.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout.LayoutParams)localObject4).setMargins(i, j, i, j);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramed.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject3);
      paramed.a().jdField_a_of_type_AndroidViewView = ((View)localObject1);
      paramed.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
      if (paramInt != 18) {
        break label1132;
      }
      a(paramDataLineMsgSet, paramed);
      b(paramDataLineMsgSet, paramed);
      return paramDataLineMsgSet;
      paramDataLineMsgSet = (DataLineMsgSet)localObject2;
      if (i != 1) {
        break;
      }
      paramDataLineMsgSet = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843324);
      break;
    }
    label1132:
    b(paramDataLineMsgSet, paramed);
    return paramDataLineMsgSet;
  }
  
  protected void a(int paramInt, ed paramed, DataLineMsgSet paramDataLineMsgSet)
  {
    c(paramed, paramDataLineMsgSet);
    a(paramDataLineMsgSet, paramed);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      amyl localamyl = (amyl)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131296269);
      if (localamyl != null)
      {
        paramInt = ackc.a(localamyl.getBitmap());
        paramed.a().setTextColor(ColorStateList.valueOf(paramInt));
      }
    }
    if (a(paramDataLineMsgSet.getMsgId()))
    {
      paramDataLineMsgSet = baiu.a(this.jdField_a_of_type_AndroidContentContext, 3, paramDataLineMsgSet.getTime() * 1000L);
      paramed.a().setVisibility(0);
      paramed.a().setText(paramDataLineMsgSet);
      return;
    }
    paramed.a().setVisibility(8);
  }
  
  protected void a(DataLineMsgRecord paramDataLineMsgRecord, View paramView, float paramFloat)
  {
    super.a(paramDataLineMsgRecord, paramView, paramFloat);
    if ((paramDataLineMsgRecord == null) || (paramView == null)) {}
    do
    {
      return;
      float f = paramFloat;
      if (paramFloat < paramDataLineMsgRecord.progress) {
        f = paramDataLineMsgRecord.progress;
      }
      ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131298524);
      if (localProgressBar != null)
      {
        localProgressBar.setVisibility(0);
        localProgressBar.setProgress((int)(100.0F * f));
      }
      paramView = (RelativeLayout)paramView.findViewById(2131300634);
    } while (paramView == null);
    int i = aciy.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aciy.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(i, i, j, 0);
      return;
    }
    paramView.setPadding(j, i, i, 0);
  }
  
  void a(AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str = apdh.a(paramDataLineMsgRecord.filename);
    if (TextUtils.isEmpty(str)) {
      paramAsyncImageView.setImageResource(2130843465);
    }
    int i;
    do
    {
      return;
      paramAsyncImageView.setDefaultImage(apck.b(str));
      if (apck.a(str) == 0)
      {
        str = paramDataLineMsgRecord.filename;
        if (bace.b(paramDataLineMsgRecord.thumbPath)) {
          str = paramDataLineMsgRecord.thumbPath;
        }
        for (;;)
        {
          paramAsyncImageView.setAsyncImage(str);
          return;
          if (bace.b(paramDataLineMsgRecord.path)) {
            str = paramDataLineMsgRecord.path;
          }
        }
      }
      i = apck.b(str);
    } while (i == 0);
    paramAsyncImageView.setImageResource(i);
  }
  
  protected boolean a(int paramInt)
  {
    return (paramInt == 17) || (paramInt == 18);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = super.getItemViewType(paramInt);
    if (i == 10) {
      paramInt = 18;
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (i != 3);
    return 17;
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount() + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dx
 * JD-Core Version:    0.7.0.1
 */