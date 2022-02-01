import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
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

public class sof
  extends aaew<TabChannelCoverInfo>
{
  public static final String a;
  private Map<Integer, rcn> jdField_a_of_type_JavaUtilMap;
  private ojc jdField_a_of_type_Ojc;
  private TabLayout b;
  
  static
  {
    jdField_a_of_type_JavaLangString = sof.class.getSimpleName();
  }
  
  public sof(Context paramContext, List<TabChannelCoverInfo> paramList, TabLayout paramTabLayout, ojc paramojc)
  {
    super(paramContext, paramList);
    this.b = paramTabLayout;
    this.jdField_a_of_type_Ojc = paramojc;
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(this.jdField_a_of_type_Ojc.c());
    if (localTabChannelCoverInfo != null) {}
    for (int i = localTabChannelCoverInfo.mChannelCoverId;; i = 0)
    {
      VideoReport.reportEvent("clck", new pil().a(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId)).a("14").b("channel_bar").c("click_channel").a().a("eid", "channel_button").a("ref_channel", Integer.valueOf(i)).a());
      return;
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
    if (pch.a()) {
      return 11;
    }
    return 6;
  }
  
  protected int a()
  {
    return 2131560226;
  }
  
  protected void a(aaex paramaaex, TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    TextView localTextView = (TextView)paramaaex.a(2131379877);
    Object localObject2 = (ImageView)paramaaex.a(2131369264);
    ImageView localImageView2 = (ImageView)paramaaex.a(2131369267);
    Object localObject1 = (ImageView)paramaaex.a(2131371719);
    a(new View[] { localTextView, localObject2, localImageView2, localObject1 });
    ImageView localImageView1 = (ImageView)paramaaex.a(2131369357);
    if (paramTabChannelCoverInfo != null)
    {
      if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelCoverPicUrl))
      {
        localImageView2.setVisibility(0);
        localImageView2.setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo.mChannelCoverPicUrl, true));
      }
      if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mIconUrl)) {
        ((ImageView)localObject2).setVisibility(0);
      }
    }
    label781:
    try
    {
      ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo.mIconUrl, true));
      if ((!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelCoverName)) && (paramTabChannelCoverInfo.onlyCover == 0))
      {
        localTextView.setText(paramTabChannelCoverInfo.mChannelCoverName);
        if (paramTabChannelCoverInfo.fontsColor != 0)
        {
          i = paramTabChannelCoverInfo.fontsColor;
          localTextView.setTextColor(i);
          localTextView.setVisibility(0);
        }
      }
      else
      {
        if (paramTabChannelCoverInfo.redPoint == null) {
          break label764;
        }
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("");
        if (!paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean) {
          break label747;
        }
        long l = System.currentTimeMillis() / 1000L;
        if ((paramTabChannelCoverInfo.redPoint.c == 0L) || ((float)(l - paramTabChannelCoverInfo.redPoint.c) <= 2.5F) || ((float)(l / 3600L - paramTabChannelCoverInfo.redPoint.c / 3600L) >= 1.0F)) {
          break label618;
        }
        i = 1;
        if ((paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Long > l) || ((paramTabChannelCoverInfo.redPoint.b != 0L) && (paramTabChannelCoverInfo.redPoint.b < l))) {
          break label730;
        }
        if (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Int != 0) {
          break label624;
        }
        localImageView1.setVisibility(0);
        paramaaex.a().setOnClickListener(new sog(this, paramTabChannelCoverInfo, paramInt, paramTabChannelCoverInfo, localImageView1));
        if (this.b != null)
        {
          i = this.b.getFirstVisiblePosition();
          int j = this.b.getLastVisiblePosition();
          if ((paramInt >= i) && (paramInt <= j) && (this.jdField_a_of_type_JavaUtilMap != null))
          {
            localObject1 = new rdx();
            ((rcn)localObject1).a = paramTabChannelCoverInfo;
            ((rcn)localObject1).l = paramInt;
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), localObject1);
          }
        }
        if (this.jdField_a_of_type_Ojc != null)
        {
          paramaaex = paramaaex.a(2131368957);
          if (paramInt != this.jdField_a_of_type_Ojc.c()) {
            break label781;
          }
          localTextView.setTextColor(localTextView.getResources().getColor(2131166902));
          localTextView.setTypeface(Typeface.defaultFromStyle(1));
          paramaaex.setVisibility(0);
          if (this.jdField_a_of_type_Ojc.a() == 0)
          {
            paramTabChannelCoverInfo = (ViewGroup.MarginLayoutParams)paramaaex.getLayoutParams();
            paramTabChannelCoverInfo.leftMargin = ViewUtils.dpToPx(0.0F);
            paramTabChannelCoverInfo.rightMargin = ViewUtils.dpToPx(0.0F);
            paramaaex.setLayoutParams(paramTabChannelCoverInfo);
          }
        }
        return;
      }
    }
    catch (Exception localException)
    {
      label730:
      for (;;)
      {
        int i;
        label618:
        label747:
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "load channel cover error : " + localException);
          continue;
          i = -16777216;
          continue;
          i = 0;
          continue;
          label624:
          if ((paramInt < b()) && (i == 0))
          {
            if (ojc.b)
            {
              ((ImageView)localObject1).setVisibility(0);
              TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 1.0F, 1, -1.0F, 1, -1.0F, 1, 1.0F);
              localTranslateAnimation.setDuration(3000L);
              localTranslateAnimation.setRepeatCount(1);
              localTranslateAnimation.setStartOffset(1000L);
              localTranslateAnimation.setFillAfter(true);
              ((ImageView)localObject1).startAnimation(localTranslateAnimation);
            }
            paramTabChannelCoverInfo.redPoint.c = (System.currentTimeMillis() / 1000L);
            this.jdField_a_of_type_Ojc.a(paramTabChannelCoverInfo);
            continue;
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            label764:
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            localTextView.setTextColor(localTextView.getResources().getColor(2131166903));
            localTextView.setTypeface(Typeface.defaultFromStyle(0));
            paramaaex.setVisibility(4);
          }
        }
      }
    }
  }
  
  public void a(Map<Integer, rcn> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sof
 * JD-Core Version:    0.7.0.1
 */