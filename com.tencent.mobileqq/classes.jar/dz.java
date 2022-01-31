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

public class dz
  extends dt
{
  private View.OnClickListener b = new ea(this);
  private View.OnClickListener c = new eb(this);
  
  public dz(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramDataLineMsgSetList, paramLiteActivity, paramQQAppInterface);
  }
  
  private void a(View paramView, ef paramef)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131371615);
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2130838161);
    localImageView.setId(2131364190);
    paramef.a().jdField_a_of_type_AndroidWidgetImageView = localImageView;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramView.addView(localImageView, localLayoutParams);
    localImageView.setVisibility(8);
    localImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692475));
    localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2130838156);
    localImageView.setId(2131364177);
    paramef.a().jdField_b_of_type_AndroidWidgetImageView = localImageView;
    paramef = new RelativeLayout.LayoutParams(-2, -2);
    paramef.addRule(13);
    paramView.addView(localImageView, paramef);
    localImageView.setVisibility(8);
    localImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692954));
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, ef paramef)
  {
    String str = "";
    if (paramDataLineMsgRecord.isSendFromLocal()) {
      if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc)) {
        str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692563);
      }
    }
    while (!TextUtils.isEmpty(str))
    {
      paramef.a().c.setVisibility(0);
      paramef.a().c.setText(str);
      return;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L) {
        str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131694055);
      } else if (paramDataLineMsgRecord.bIsTransfering) {
        str = "";
      } else if (!paramDataLineMsgRecord.issuc) {
        if ((paramDataLineMsgRecord.bIsSended) || (paramDataLineMsgRecord.nOpType == 1))
        {
          str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692561);
        }
        else
        {
          str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692562);
          continue;
          if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc)) {
            str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692555);
          } else if (paramDataLineMsgRecord.fileMsgStatus == 2L) {
            str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131694055);
          } else if (paramDataLineMsgRecord.bIsTransfering) {
            str = "";
          } else if (!paramDataLineMsgRecord.issuc) {
            str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692561);
          }
        }
      }
    }
    paramef.a().c.setVisibility(8);
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet, ef paramef)
  {
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      paramef.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849371);
      return;
    }
    paramef.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849195);
  }
  
  private boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) && (arof.a(paramDataLineMsgRecord.path));
  }
  
  private void b(View paramView, ef paramef)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131371615);
    CircleFileStateView localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
    localCircleFileStateView.setId(2131364175);
    localCircleFileStateView.setProgressRingWidth(0.0F);
    localCircleFileStateView.setCenterBgColor(-1);
    localCircleFileStateView.setState(2);
    paramef.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = localCircleFileStateView;
    int i = aekt.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramView.addView(localCircleFileStateView, new RelativeLayout.LayoutParams(i, i));
    localCircleFileStateView.setVisibility(4);
    localCircleFileStateView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692556));
    localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
    localCircleFileStateView.setId(2131364176);
    localCircleFileStateView.setProgressRingWidth(0.0F);
    localCircleFileStateView.setCenterBgColor(-1);
    localCircleFileStateView.setState(1);
    paramef.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView = localCircleFileStateView;
    paramView.addView(localCircleFileStateView, new RelativeLayout.LayoutParams(i, i));
    localCircleFileStateView.setVisibility(4);
    localCircleFileStateView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692764));
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord, ef paramef)
  {
    if ((paramDataLineMsgRecord.progress == 1.0F) || (!paramDataLineMsgRecord.issuc) || (paramDataLineMsgRecord.fileMsgStatus == 1L) || (paramDataLineMsgRecord.fileMsgStatus == 2L))
    {
      paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      i = aekt.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = aekt.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramef.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, i);
        return;
      }
      paramef.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, i);
      return;
    }
    int i = (int)(paramDataLineMsgRecord.progress * 100.0F);
    paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
    paramef.a().jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692598) + i);
    i = aekt.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aekt.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramef.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, 0);
      return;
    }
    paramef.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, 0);
  }
  
  private void c(DataLineMsgRecord paramDataLineMsgRecord, ef paramef)
  {
    ImageView localImageView1 = paramef.a().jdField_a_of_type_AndroidWidgetImageView;
    ImageView localImageView2 = paramef.a().jdField_b_of_type_AndroidWidgetImageView;
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
      localImageView1.setTag(paramef);
      localImageView2.setTag(paramef);
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
  
  private void c(ef paramef, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramef == null) {}
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
    a(paramef.a().jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramDataLineMsgSet);
    paramef.a().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    paramef.a().jdField_b_of_type_AndroidWidgetTextView.setText(arof.a(l, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    b(paramDataLineMsgSet, paramef);
    a(paramDataLineMsgSet, paramef);
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      localObject = paramef.a().jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = paramef.a().jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = paramef.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      if (localObject != null) {
        ((CircleFileStateView)localObject).setVisibility(8);
      }
      localObject = paramef.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      if (localObject != null) {
        ((CircleFileStateView)localObject).setVisibility(8);
      }
      if ((paramDataLineMsgSet.bIsSended) || (paramDataLineMsgSet.nOpType == 1)) {
        d(paramDataLineMsgSet, paramef);
      }
    }
    for (;;)
    {
      e(paramDataLineMsgSet, paramef);
      return;
      c(paramDataLineMsgSet, paramef);
      continue;
      d(paramDataLineMsgSet, paramef);
    }
  }
  
  private void d(DataLineMsgRecord paramDataLineMsgRecord, ef paramef)
  {
    CircleFileStateView localCircleFileStateView1 = paramef.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
    CircleFileStateView localCircleFileStateView2 = paramef.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView;
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
      localCircleFileStateView1.setTag(paramef);
      localCircleFileStateView2.setTag(paramef);
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
  
  private void e(DataLineMsgRecord paramDataLineMsgRecord, ef paramef)
  {
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc) && (!a(paramDataLineMsgRecord)))
    {
      CircleFileStateView localCircleFileStateView1 = paramef.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      CircleFileStateView localCircleFileStateView2 = paramef.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      localCircleFileStateView1.setVisibility(0);
      localCircleFileStateView1.setState(2);
      localCircleFileStateView2.setVisibility(8);
      if (!paramDataLineMsgRecord.isSendFromLocal()) {
        paramef.a().c.setVisibility(8);
      }
      localCircleFileStateView1.setTag(paramef);
      localCircleFileStateView2.setTag(paramef);
      localCircleFileStateView1.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      localCircleFileStateView2.setOnClickListener(this.c);
    }
  }
  
  protected View a(int paramInt, ef paramef, DataLineMsgSet paramDataLineMsgSet)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int i;
    if (paramInt == 17)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558978, null);
      localObject3 = (ImageView)((View)localObject1).findViewById(2131367808);
      localObject2 = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843762);
      i = DataLineMsgRecord.getDevTypeBySet(paramDataLineMsgSet);
      if (i == 0)
      {
        paramDataLineMsgSet = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843762);
        ((ImageView)localObject3).setImageDrawable(paramDataLineMsgSet);
      }
    }
    for (paramDataLineMsgSet = (DataLineMsgSet)localObject1;; paramDataLineMsgSet = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558979, null))
    {
      paramef.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramDataLineMsgSet.findViewById(2131370783));
      paramef.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramef);
      paramef.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      paramef.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
      paramef.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramef.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      paramef.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramef.jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
      paramef.a((TextView)paramDataLineMsgSet.findViewById(2131365006));
      i = aekt.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = aekt.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131364171);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
      ((RelativeLayout)localObject1).setPadding(((Resources)localObject2).getDimensionPixelSize(2131296294), ((Resources)localObject2).getDimensionPixelSize(2131296296), ((Resources)localObject2).getDimensionPixelSize(2131296293), ((Resources)localObject2).getDimensionPixelSize(2131296295));
      localObject3 = new RelativeLayout.LayoutParams(BaseChatItemLayout.y, -2);
      int k = ((Resources)localObject2).getDimensionPixelSize(2131298815);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131367808);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject2).setMinimumHeight(aekt.a(76.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout)localObject2).setOrientation(1);
      localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10, 2131364171);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject3).setId(2131366324);
      Object localObject4 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject3).setPadding(i, i, i, 0);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramef.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
      k = aekt.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject4 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      ((AsyncImageView)localObject4).setWidth(k);
      ((AsyncImageView)localObject4).setHeight(k);
      ((AsyncImageView)localObject4).setId(2131364140);
      ((AsyncImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramef.a().jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject4);
      localObject4 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
      ((TextView)localObject4).setId(2131364142);
      ((TextView)localObject4).setGravity(48);
      ((TextView)localObject4).setIncludeFontPadding(false);
      ((TextView)localObject4).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject4).setTextSize(1, 17.0F);
      ((TextView)localObject4).setMaxLines(2);
      ((TextView)localObject4).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131364140);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramef.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131364139);
      ((TextView)localObject4).setSingleLine();
      if (bhou.e()) {
        ((TextView)localObject4).setAlpha(0.75F);
      }
      ((TextView)localObject4).setGravity(17);
      ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject4).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131364142);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramef.a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131364144);
      ((TextView)localObject4).setSingleLine();
      if (bhou.e()) {
        ((TextView)localObject4).setAlpha(0.75F);
      }
      ((TextView)localObject4).setGravity(17);
      ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject4).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364139);
      localLayoutParams.addRule(8, 2131364139);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramef.a().c = ((TextView)localObject4);
      localObject3 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
      ((ProgressBar)localObject3).setId(2131364143);
      ((ProgressBar)localObject3).setMax(100);
      ((ProgressBar)localObject3).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837923));
      localObject4 = new LinearLayout.LayoutParams(-1, aekt.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout.LayoutParams)localObject4).setMargins(i, j, i, j);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramef.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject3);
      paramef.a().jdField_a_of_type_AndroidViewView = ((View)localObject1);
      paramef.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
      if (paramInt != 18) {
        break label1132;
      }
      a(paramDataLineMsgSet, paramef);
      b(paramDataLineMsgSet, paramef);
      return paramDataLineMsgSet;
      paramDataLineMsgSet = (DataLineMsgSet)localObject2;
      if (i != 1) {
        break;
      }
      paramDataLineMsgSet = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130843760);
      break;
    }
    label1132:
    b(paramDataLineMsgSet, paramef);
    return paramDataLineMsgSet;
  }
  
  protected void a(int paramInt, ef paramef, DataLineMsgSet paramDataLineMsgSet)
  {
    c(paramef, paramDataLineMsgSet);
    a(paramDataLineMsgSet, paramef);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      apgf localapgf = (apgf)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361805);
      if (localapgf != null)
      {
        paramInt = aemb.a(localapgf.getBitmap());
        paramef.a().setTextColor(ColorStateList.valueOf(paramInt));
      }
    }
    if (a(paramDataLineMsgSet.getMsgId()))
    {
      paramDataLineMsgSet = bdjj.a(this.jdField_a_of_type_AndroidContentContext, 3, paramDataLineMsgSet.getTime() * 1000L);
      paramef.a().setVisibility(0);
      paramef.a().setText(paramDataLineMsgSet);
      return;
    }
    paramef.a().setVisibility(8);
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
      ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131364143);
      if (localProgressBar != null)
      {
        localProgressBar.setVisibility(0);
        localProgressBar.setProgress((int)(100.0F * f));
      }
      paramView = (RelativeLayout)paramView.findViewById(2131366324);
    } while (paramView == null);
    int i = aekt.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aekt.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(i, i, j, 0);
      return;
    }
    paramView.setPadding(j, i, i, 0);
  }
  
  void a(AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str = arof.a(paramDataLineMsgRecord.filename);
    if (TextUtils.isEmpty(str)) {
      paramAsyncImageView.setImageResource(2130843909);
    }
    int i;
    do
    {
      return;
      paramAsyncImageView.setDefaultImage(arni.b(str));
      if (arni.a(str) == 0)
      {
        str = paramDataLineMsgRecord.filename;
        if (bdcs.b(paramDataLineMsgRecord.thumbPath)) {
          str = paramDataLineMsgRecord.thumbPath;
        }
        for (;;)
        {
          paramAsyncImageView.setAsyncImage(str);
          return;
          if (bdcs.b(paramDataLineMsgRecord.path)) {
            str = paramDataLineMsgRecord.path;
          }
        }
      }
      i = arni.b(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dz
 * JD-Core Version:    0.7.0.1
 */