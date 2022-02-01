import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import java.util.Map;

public class tbq
  extends aaui<TabChannelCoverInfo>
{
  public static final String a;
  private Map<Integer, rot> jdField_a_of_type_JavaUtilMap;
  private oqy jdField_a_of_type_Oqy;
  private TabLayout b;
  
  static
  {
    jdField_a_of_type_JavaLangString = tbq.class.getSimpleName();
  }
  
  public tbq(Context paramContext, List<TabChannelCoverInfo> paramList, TabLayout paramTabLayout, oqy paramoqy)
  {
    super(paramContext, paramList);
    this.b = paramTabLayout;
    this.jdField_a_of_type_Oqy = paramoqy;
  }
  
  private void a(aauj paramaauj, int paramInt, TextView paramTextView)
  {
    if (this.jdField_a_of_type_Oqy != null)
    {
      paramaauj = paramaauj.a(2131369118);
      if (paramInt != this.jdField_a_of_type_Oqy.d()) {
        break label91;
      }
      paramTextView.setTextColor(paramTextView.getResources().getColor(2131166916));
      paramTextView.setTypeface(Typeface.defaultFromStyle(1));
      paramaauj.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Oqy.a() == 0)
      {
        paramTextView = (ViewGroup.MarginLayoutParams)paramaauj.getLayoutParams();
        paramTextView.leftMargin = ViewUtils.dpToPx(0.0F);
        paramTextView.rightMargin = ViewUtils.dpToPx(0.0F);
        paramaauj.setLayoutParams(paramTextView);
      }
      return;
      label91:
      paramTextView.setTextColor(paramTextView.getResources().getColor(2131166917));
      paramTextView.setTypeface(Typeface.defaultFromStyle(0));
      paramaauj.setVisibility(4);
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(this.jdField_a_of_type_Oqy.d());
    if (localTabChannelCoverInfo != null) {}
    for (int i = localTabChannelCoverInfo.mChannelCoverId;; i = 0)
    {
      VideoReport.reportEvent("clck", new pti().a(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId)).a("14").b("channel_bar").c("click_channel").a().a("eid", "channel_button").a("ref_channel", Integer.valueOf(i)).a());
      return;
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt, ImageView paramImageView1, ImageView paramImageView2)
  {
    if (paramTabChannelCoverInfo.redPoint != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      if (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)
      {
        long l = System.currentTimeMillis() / 1000L;
        boolean bool = a(paramTabChannelCoverInfo, l);
        if ((paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Long <= l) && ((paramTabChannelCoverInfo.redPoint.b == 0L) || (paramTabChannelCoverInfo.redPoint.b >= l)))
        {
          a(paramTabChannelCoverInfo, paramInt, paramImageView1, paramImageView2, bool);
          return;
        }
        paramImageView2.setVisibility(8);
        paramImageView1.setVisibility(8);
        return;
      }
      paramImageView2.setVisibility(8);
      paramImageView1.setVisibility(8);
      return;
    }
    paramImageView2.setVisibility(8);
    paramImageView1.setVisibility(8);
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean)
  {
    if (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Int == 0) {
      paramImageView2.setVisibility(0);
    }
    while ((paramInt >= b()) || (paramBoolean)) {
      return;
    }
    if (oqy.b)
    {
      paramImageView1.setVisibility(0);
      paramImageView2 = new TranslateAnimation(1, 1.0F, 1, -1.0F, 1, -1.0F, 1, 1.0F);
      paramImageView2.setDuration(3000L);
      paramImageView2.setRepeatCount(1);
      paramImageView2.setStartOffset(1000L);
      paramImageView2.setFillAfter(true);
      paramImageView1.startAnimation(paramImageView2);
    }
    paramTabChannelCoverInfo.redPoint.c = (System.currentTimeMillis() / 1000L);
    this.jdField_a_of_type_Oqy.a(paramTabChannelCoverInfo);
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo1, TextView paramTextView, ImageView paramImageView1, ImageView paramImageView2, TabChannelCoverInfo paramTabChannelCoverInfo2)
  {
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo2.mChannelCoverPicUrl))
    {
      paramImageView2.setVisibility(0);
      paramImageView2.setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo2.mChannelCoverPicUrl, true));
    }
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo2.mIconUrl)) {
      paramImageView1.setVisibility(0);
    }
    try
    {
      paramImageView1.setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo2.mIconUrl, true));
      if ((!TextUtils.isEmpty(paramTabChannelCoverInfo2.mChannelCoverName)) && (paramTabChannelCoverInfo2.onlyCover == 0))
      {
        paramTextView.setText(paramTabChannelCoverInfo1.mChannelCoverName);
        if (paramTabChannelCoverInfo1.fontsColor != 0)
        {
          i = paramTabChannelCoverInfo1.fontsColor;
          paramTextView.setTextColor(i);
          paramTextView.setVisibility(0);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramImageView1)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "load channel cover error : " + paramImageView1);
          continue;
          i = -16777216;
        }
      }
    }
  }
  
  private void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setVisibility(8);
      i += 1;
    }
  }
  
  private int b()
  {
    if (pli.a()) {
      return 11;
    }
    return 6;
  }
  
  protected int a()
  {
    return 2131560272;
  }
  
  protected void a(aauj paramaauj, TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    TextView localTextView = (TextView)paramaauj.a(2131380210);
    Object localObject = (ImageView)paramaauj.a(2131369431);
    ImageView localImageView1 = (ImageView)paramaauj.a(2131369434);
    ImageView localImageView2 = (ImageView)paramaauj.a(2131371907);
    a(new View[] { localTextView, localObject, localImageView1, localImageView2 });
    ImageView localImageView3 = (ImageView)paramaauj.a(2131369524);
    if (paramTabChannelCoverInfo != null)
    {
      a(paramTabChannelCoverInfo, localTextView, (ImageView)localObject, localImageView1, paramTabChannelCoverInfo);
      a(paramTabChannelCoverInfo, paramInt, localImageView2, localImageView3);
      paramaauj.a().setOnClickListener(new tbr(this, paramTabChannelCoverInfo, paramInt, paramTabChannelCoverInfo, localImageView3));
      if (this.b != null)
      {
        int i = this.b.getFirstVisiblePosition();
        int j = this.b.getLastVisiblePosition();
        if ((paramInt >= i) && (paramInt <= j) && (this.jdField_a_of_type_JavaUtilMap != null))
        {
          localObject = new rqe();
          ((rot)localObject).a = paramTabChannelCoverInfo;
          ((rot)localObject).l = paramInt;
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), localObject);
        }
      }
    }
    a(paramaauj, paramInt, localTextView);
  }
  
  public void a(Map<Integer, rot> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  @VisibleForTesting
  boolean a(TabChannelCoverInfo paramTabChannelCoverInfo, long paramLong)
  {
    return (paramTabChannelCoverInfo.redPoint.c != 0L) && ((float)(paramLong - paramTabChannelCoverInfo.redPoint.c) > 2.5F) && ((float)(paramLong / 3600L - paramTabChannelCoverInfo.redPoint.c / 3600L) < 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbq
 * JD-Core Version:    0.7.0.1
 */