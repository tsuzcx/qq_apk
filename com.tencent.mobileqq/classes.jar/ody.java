import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ody
  extends BaseAdapter
  implements View.OnClickListener, tvo
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  List<RecentShopParcel> jdField_a_of_type_JavaUtilList;
  odq jdField_a_of_type_Odq;
  tvl jdField_a_of_type_Tvl;
  int b;
  
  public ody(Context paramContext, SwipListView paramSwipListView, odq paramodq, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = ((localDisplayMetrics.widthPixels - 8) / 3);
    this.jdField_b_of_type_Int = ((localDisplayMetrics.widthPixels - 8) % 3);
    this.jdField_a_of_type_Tvl = new tvl();
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    this.jdField_a_of_type_Odq = paramodq;
    paramContext = View.inflate(paramContext, 2131561932, null);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131365996);
    paramContext.findViewById(2131363775).setOnClickListener(new odz(this, paramString));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(paramContext);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Tvl.a();
    this.jdField_a_of_type_ComTencentWidgetSwipListView = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    this.jdField_a_of_type_Odq = null;
  }
  
  public void a(RecentShopParcel paramRecentShopParcel)
  {
    if ((paramRecentShopParcel == null) || (TextUtils.isEmpty(paramRecentShopParcel.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      if (paramRecentShopParcel.jdField_c_of_type_Int != 1) {
        break;
      }
      paramRecentShopParcel = ((EcshopWebActivity)this.jdField_a_of_type_AndroidContentContext).jdField_b_of_type_JavaLangString;
    } while (TextUtils.isEmpty(paramRecentShopParcel));
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramRecentShopParcel);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    try
    {
      this.jdField_a_of_type_Odq.jdField_a_of_type_Odu.a(134246437, null, null, null, null, ((EcshopWebActivity)this.jdField_a_of_type_AndroidContentContext).jdField_a_of_type_Long, false);
      return;
    }
    catch (Exception paramRecentShopParcel)
    {
      return;
    }
    int i = paramRecentShopParcel.jdField_b_of_type_Int;
    String str = paramRecentShopParcel.jdField_a_of_type_JavaLangString;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uinname", paramRecentShopParcel.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", i);
    localIntent.putExtra("jump_from", 1);
    boolean bool;
    if (i > 0)
    {
      bool = true;
      localIntent.putExtra("has_unread_msg", bool);
      paramRecentShopParcel.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_Odq.c.get(str) != null) {
        break label375;
      }
      i = 0;
      label242:
      if (i > 0)
      {
        if (i / 1000 <= 0) {
          break label399;
        }
        localObject = new BigDecimal(i / 1000.0F);
      }
    }
    label399:
    for (localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693911) + ((BigDecimal)localObject).setScale(1, 4).floatValue() + "km";; localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131693911) + i + "m")
    {
      localIntent.putExtra("pub_account_type", "type_ecshop_account");
      localIntent.putExtra("ecshop_distance_tip", (String)localObject);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      bcst.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helper", "Clk_shopItem", 0, 0, str, "", paramRecentShopParcel.jdField_b_of_type_JavaLangString, "");
      return;
      bool = false;
      break;
      label375:
      i = ((Integer)this.jdField_a_of_type_Odq.c.get(str)).intValue();
      break label242;
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Odq == null)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
    label38:
    Object localObject;
    if (i <= j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(i);
      if (localObject != null) {
        break label65;
      }
    }
    for (;;)
    {
      i += 1;
      break label38;
      break;
      label65:
      localObject = (oea)((View)localObject).getTag();
      if ((localObject != null) && (paramString.equals(((oea)localObject).jdField_a_of_type_JavaLangString)))
      {
        Bitmap localBitmap = this.jdField_a_of_type_Odq.a(paramString);
        if (localBitmap != null) {
          ((oea)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        }
      }
    }
  }
  
  public void a(List<RecentShopParcel> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public boolean a(ImageView paramImageView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (paramImageView == null)) {
      return false;
    }
    int i = ((Integer)paramImageView.getTag(2131374728)).intValue();
    int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
    return (i >= j) && (i <= k);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (RecentShopParcel)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    oea localoea;
    Object localObject1;
    float f;
    if (paramView == null)
    {
      localoea = new oea(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561934, null);
      localoea.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368138));
      localoea.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { (ImageView)paramView.findViewById(2131368379), (ImageView)paramView.findViewById(2131368380), (ImageView)paramView.findViewById(2131368381) };
      localoea.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371539));
      localoea.b = ((SingleLineTextView)paramView.findViewById(2131371338));
      localoea.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380253));
      localoea.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
      localoea.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      localoea.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370640));
      localoea.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365766);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167074);
      localoea.b.setExtendTextColor((ColorStateList)localObject1, 0);
      localoea.b.setExtendTextSize(12.0F, 0);
      f = bgln.a();
      localoea.b.setExtendTextPadding((int)(f * 5.0F), 2);
      paramView.setTag(localoea);
      if ((this.jdField_a_of_type_Odq != null) && (this.jdField_a_of_type_Odq.jdField_a_of_type_Boolean))
      {
        paramView.findViewById(2131365590).setVisibility(0);
        localObject1 = new ColorStateList(new int[][] { new int[0] }, new int[] { -8947849 });
        paramView.findViewById(2131365766).setBackgroundResource(2130847087);
        localoea.b.setExtendTextColor((ColorStateList)localObject1, 0);
        localoea.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#FF777777"));
        localoea.b.setTextColor(Color.parseColor("#FF000000"));
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = (RecentShopParcel)getItem(paramInt);
      if (localObject2 != null) {
        break;
      }
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localoea = (oea)paramView.getTag();
    }
    int i;
    label420:
    label606:
    int j;
    if (((RecentShopParcel)localObject2).jdField_b_of_type_Long > ((RecentShopParcel)localObject2).jdField_a_of_type_Long)
    {
      i = 1;
      localoea.jdField_a_of_type_JavaLangString = ((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString;
      if (((RecentShopParcel)localObject2).jdField_a_of_type_Int == 0) {
        break label1372;
      }
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(((RecentShopParcel)localObject2).jdField_a_of_type_Int);
      localoea.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((Drawable)localObject1).setBounds(0, 0, afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localoea.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, (Drawable)localObject1);
      label520:
      localObject1 = (String)this.jdField_a_of_type_Odq.d.get(((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!this.jdField_a_of_type_Odq.a((String)localObject1))) {
        break label1385;
      }
      localObject1 = ((RecentShopParcel)localObject2).jdField_b_of_type_JavaLangString + "(" + this.jdField_a_of_type_Odq.a((String)localObject1) + ")";
      localoea.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject1);
      localoea.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
      if (TextUtils.isEmpty(((RecentShopParcel)localObject2).jdField_c_of_type_JavaLangString)) {
        break label1395;
      }
      localoea.b.setExtendText(((RecentShopParcel)localObject2).jdField_c_of_type_JavaLangString, 0);
      label652:
      localoea.b.setExtendText(" ", 2);
      if (((RecentShopParcel)localObject2).jdField_b_of_type_Int <= 0) {
        break label1409;
      }
      j = 3;
      label675:
      bkjh.a(localoea.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, j, ((RecentShopParcel)localObject2).jdField_b_of_type_Int, 2130850392, 99, null);
      localoea.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131374727, localObject2);
      localObject1 = this.jdField_a_of_type_Odq.a(((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label1415;
      }
      localoea.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      label738:
      localoea.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localoea.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
      localoea.jdField_a_of_type_AndroidWidgetImageView.setTag(2131374727, localObject2);
      if ((this.jdField_a_of_type_Odq.c != null) && (!this.jdField_a_of_type_Odq.c.isEmpty()) && (this.jdField_a_of_type_Odq.c.get(((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString) != null)) {
        break label1434;
      }
      j = 0;
      label821:
      if (j <= 0) {
        break label1767;
      }
      if (j / 1000 <= 0) {
        break label1462;
      }
      localObject1 = new BigDecimal(j / 1000.0F);
      localObject1 = "[" + this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693911) + ((BigDecimal)localObject1).setScale(1, 4).floatValue() + "km]";
    }
    for (;;)
    {
      label903:
      Object localObject3 = new bdnt(String.valueOf(((RecentShopParcel)localObject2).d).replaceFirst("^\\s+", ""), 3, 20);
      Object localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = new SpannableString((CharSequence)localObject1);
        ((Spannable)localObject4).setSpan(new ForegroundColorSpan(Color.rgb(255, 132, 68)), 0, ((String)localObject1).length(), 33);
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject4);
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject3);
        localoea.b.setText((CharSequence)localObject1);
        label1018:
        if (i == 0) {
          break label1522;
        }
        localoea.b.setCompoundDrawablesWithIntrinsicBounds(2130839532, 0);
        label1035:
        localoea.jdField_a_of_type_AndroidWidgetButton.setTag(2131374727, localObject2);
        localoea.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        f = afur.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if ((!TextUtils.isEmpty(((RecentShopParcel)localObject2).e)) && (i == 0)) {
          break label1535;
        }
        paramView.findViewById(2131368502).setVisibility(8);
        label1101:
        localoea.jdField_a_of_type_AndroidViewView.setTag(2131374727, localObject2);
        localoea.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        paramView.setTag(-3, Integer.valueOf((int)f));
        localObject1 = (LinearLayout.LayoutParams)localoea.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
        if (((RecentShopParcel)localObject2).jdField_c_of_type_Int != 1) {
          break label1717;
        }
        localoea.b.setExtendText("", 0);
        localoea.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        localObject3 = (ImageButton)paramView.findViewById(2131363742);
        ((ImageButton)localObject3).setVisibility(0);
        ((ImageButton)localObject3).setTag(2131374727, localObject2);
        ((ImageButton)localObject3).setOnClickListener(this);
        localObject3 = ((EcshopWebActivity)this.jdField_a_of_type_AndroidContentContext).jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = (URLImageView)paramView.findViewById(2131362089);
          localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839504);
        }
      }
      label1318:
      label1372:
      label1385:
      label1522:
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject4);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
        localObject3 = URLDrawable.getDrawable((String)localObject3, localURLDrawableOptions);
        if (localObject3 != null)
        {
          if (((URLDrawable)localObject3).getStatus() == 2) {
            ((URLDrawable)localObject3).restartDownload();
          }
          ((URLImageView)localObject2).setImageDrawable((Drawable)localObject3);
          ((URLImageView)localObject2).setVisibility(0);
        }
      }
      catch (Exception localException)
      {
        label1395:
        label1535:
        break label1318;
      }
      for (((LinearLayout.LayoutParams)localObject1).rightMargin = afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; ((LinearLayout.LayoutParams)localObject1).rightMargin = afur.a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
      {
        localoea.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramView.setOnClickListener(this);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        localObject1 = paramView;
        break;
        i = 0;
        break label420;
        localoea.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        break label520;
        localObject1 = ((RecentShopParcel)localObject2).jdField_b_of_type_JavaLangString;
        break label606;
        localoea.b.setExtendText("", 0);
        break label652;
        label1409:
        j = 0;
        break label675;
        label1415:
        this.jdField_a_of_type_Odq.a(this.jdField_a_of_type_AndroidContentContext, ((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString);
        break label738;
        label1434:
        j = ((Integer)this.jdField_a_of_type_Odq.c.get(((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString)).intValue();
        break label821;
        label1462:
        localObject1 = "[" + this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693911) + j + "m]";
        break label903;
        localoea.b.setText((CharSequence)localObject3);
        break label1018;
        localoea.b.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        break label1035;
        localObject1 = new ArrayList(Arrays.asList(((RecentShopParcel)localObject2).e.split(",")));
        i = 0;
        while (i < 3)
        {
          localoea.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setTag(2131374728, Integer.valueOf(paramInt));
          localObject3 = localoea.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].getLayoutParams();
          j = this.jdField_a_of_type_Int;
          ((ViewGroup.LayoutParams)localObject3).width = j;
          ((ViewGroup.LayoutParams)localObject3).height = j;
          if (i == 2) {
            ((ViewGroup.LayoutParams)localObject3).width += this.jdField_b_of_type_Int;
          }
          localoea.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.jdField_a_of_type_Tvl.a(tyc.a((String)((List)localObject1).get(i), 1), localoea.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i], ((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height, this);
          i += 1;
        }
        paramView.findViewById(2131368502).setVisibility(0);
        break label1101;
        label1717:
        paramView.findViewById(2131363742).setVisibility(8);
        paramView.findViewById(2131362089).setVisibility(8);
      }
      label1767:
      localObject1 = "";
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    RecentShopParcel localRecentShopParcel = (RecentShopParcel)paramView.getTag(2131374727);
    if (i == 2131365766) {
      a(localRecentShopParcel);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent;
      if ((i == 2131370640) || (i == 2131363742))
      {
        i = localRecentShopParcel.jdField_b_of_type_Int;
        this.jdField_a_of_type_JavaUtilList.remove(localRecentShopParcel);
        notifyDataSetChanged();
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        localIntent = new Intent("action_shop_set_read");
        localIntent.putExtra("uin", localRecentShopParcel.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("needDelete", true);
        localIntent.putExtra("unReadNum", i);
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      }
      else if (i == 2131368138)
      {
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
        localIntent.putExtra("uin", localRecentShopParcel.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("report_src_param_type", "");
        localIntent.putExtra("report_src_param_name", "");
        localIntent.setFlags(67108864);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        bcst.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helperhead", "Clk_shopItemhead", 0, 0, localRecentShopParcel.jdField_a_of_type_JavaLangString, "", localRecentShopParcel.jdField_b_of_type_JavaLangString, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ody
 * JD-Core Version:    0.7.0.1
 */