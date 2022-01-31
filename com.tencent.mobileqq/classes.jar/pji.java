import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class pji
  implements View.OnClickListener, piz
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bdbb jdField_a_of_type_Bdbb;
  private bhxx jdField_a_of_type_Bhxx;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private pgd jdField_a_of_type_Pgd;
  private rqj jdField_a_of_type_Rqj;
  private rvg jdField_a_of_type_Rvg;
  private boolean jdField_a_of_type_Boolean;
  
  public pji(Context paramContext, bdbb parambdbb, rqj paramrqj, ListView paramListView, bhxx parambhxx)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bdbb = parambdbb;
    this.jdField_a_of_type_Rqj = paramrqj;
    this.jdField_a_of_type_Bhxx = parambhxx;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  private String a(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic title empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private URL a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo.mHeaderIconUrl == null) {
      try
      {
        String str = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_icon_url.get();
        if (TextUtils.isEmpty(str)) {
          QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic icon url empty");
        }
        if (TextUtils.isEmpty(str)) {
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject = null;
        }
        Object localObject = ors.a((String)localObject);
        paramArticleInfo.mHeaderIconUrl = ((URL)localObject);
        return localObject;
      }
    }
    return paramArticleInfo.mHeaderIconUrl;
  }
  
  private List<Long> a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend uin list empty");
      }
      return localArrayList;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  private void a(String paramString)
  {
    label92:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = ors.a();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", ors.e());
        paramString = "0X800744D";
        if (this.jdField_a_of_type_Pgd != null)
        {
          if (szp.a(this.jdField_a_of_type_Pgd.e()))
          {
            paramString = "0X8009357";
            break label92;
          }
        }
        else
        {
          nrt.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
          return;
        }
        paramString = "0X800744D";
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  private void a(rvg paramrvg, pgd parampgd, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      pgd localpgd = (pgd)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131379971);
      rvg localrvg = (rvg)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131379976);
      if ((localpgd != null) && (localrvg != null) && (parampgd.a().mGroupId == localpgd.a().mGroupId))
      {
        localArrayList1.add(localrvg);
        localArrayList2.add(localpgd);
      }
      i += 1;
    }
    paramrvg = new pjm(this, paramrvg, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    if (paramInt < localArrayList1.size())
    {
      parampgd = (Animation)((rvg)localArrayList1.get(paramInt)).a().getTag(2131369027);
      if (paramInt != 0) {
        parampgd.setAnimationListener(null);
      }
      for (;;)
      {
        ((rvg)localArrayList1.get(paramInt)).a().startAnimation(parampgd);
        paramInt += 1;
        break;
        parampgd.setAnimationListener(paramrvg);
      }
    }
  }
  
  private void a(boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    int k = 8;
    int i;
    label90:
    label123:
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = a(paramArticleInfo);
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        this.jdField_a_of_type_Rvg.c.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Rvg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (!paramBoolean) {
          break label205;
        }
        i = 8;
        ((KandianUrlImageView)localObject1).setVisibility(i);
        this.jdField_a_of_type_Rvg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
        localObject1 = this.jdField_a_of_type_Rvg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView;
        int m = localObject1.length;
        i = 0;
        if (i >= m) {
          break label217;
        }
        localObject2 = localObject1[i];
        if (!paramBoolean) {
          break label210;
        }
      }
    }
    label205:
    label210:
    for (int j = 0;; j = 8)
    {
      localObject2.setVisibility(j);
      i += 1;
      break label123;
      this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 0);
      break;
      this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      break;
      i = 0;
      break label90;
    }
    label217:
    Object localObject1 = this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {
      if (a(paramArticleInfo).size() == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(i);
      this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramArticleInfo = this.jdField_a_of_type_Rvg.jdField_b_of_type_AndroidWidgetTextView;
      i = k;
      if (paramBoolean) {
        i = 0;
      }
      paramArticleInfo.setVisibility(i);
      this.jdField_a_of_type_Rvg.d.setVisibility(0);
      return;
      i = 8;
      continue;
      i = 0;
    }
  }
  
  private String b(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_jump_url.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic url empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private String c(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend description empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  public void a(rvg paramrvg, pgd parampgd)
  {
    paramrvg = parampgd.a();
    parampgd = a(paramrvg);
    int i = 0;
    if (i < Math.min(4, parampgd.size()))
    {
      if (ors.a()) {
        this.jdField_a_of_type_Rvg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageDrawable(ayvm.a(this.jdField_a_of_type_Bdbb, String.valueOf(parampgd.get(i)), 1));
      }
      for (;;)
      {
        String str = String.valueOf(parampgd.get(i));
        this.jdField_a_of_type_Rvg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setOnClickListener(new pjl(this, str, paramrvg));
        i += 1;
        break;
        this.jdField_a_of_type_Rvg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(this.jdField_a_of_type_Rqj.a(((Long)parampgd.get(i)).longValue()));
      }
    }
    i = Math.min(4, parampgd.size());
    while (i < 4)
    {
      this.jdField_a_of_type_Rvg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setVisibility(8);
      i += 1;
    }
  }
  
  public void a(rvg paramrvg, pgd parampgd, int paramInt)
  {
    this.jdField_a_of_type_Rvg = paramrvg;
    this.jdField_a_of_type_Pgd = parampgd;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pgd.a();
    if (this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_Rvg.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Pgd.a()) {
        break label179;
      }
    }
    label179:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      if (this.jdField_a_of_type_Pgd.a())
      {
        this.jdField_a_of_type_Rvg.a();
        if (this.jdField_a_of_type_Pgd.c() != 3) {
          break;
        }
        this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Rvg.f.setVisibility(8);
        if (this.jdField_a_of_type_Rvg.g != null) {
          this.jdField_a_of_type_Rvg.g.setVisibility(8);
        }
        this.jdField_a_of_type_Rvg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(0);
        this.jdField_a_of_type_Rvg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setLogic(this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Bdbb);
        this.jdField_a_of_type_Rvg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(parampgd);
      }
      return;
    }
    this.jdField_a_of_type_Rvg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(8);
    this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidViewView.setVisibility(0);
    switch (this.jdField_a_of_type_Pgd.c())
    {
    default: 
      this.jdField_a_of_type_Rvg.d.setOnClickListener(new pjj(this, parampgd, paramrvg));
      return;
    case 1: 
      this.jdField_a_of_type_Boolean = false;
      a(false, localArticleInfo);
      localObject = a(localArticleInfo);
      if (localObject == null)
      {
        this.jdField_a_of_type_Rvg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_Rvg.c.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidWidgetTextView.setText(a(localArticleInfo));
        break;
        orc.a(this.jdField_a_of_type_Rvg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (URL)localObject, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(true, localArticleInfo);
    a(paramrvg, parampgd);
    Object localObject = a(localArticleInfo);
    if (((List)localObject).size() == 1) {
      if (!ors.a()) {
        break label447;
      }
    }
    label447:
    for (localObject = bdgc.j((QQAppInterface)ors.a(), String.valueOf(((List)localObject).get(0)));; localObject = this.jdField_a_of_type_Rqj.b(((Long)((List)localObject).get(0)).longValue()))
    {
      this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidWidgetTextView.setText(ors.d((String)localObject));
      this.jdField_a_of_type_Rvg.jdField_b_of_type_AndroidWidgetTextView.setText(c(localArticleInfo));
      break;
    }
  }
  
  public void a(rvg paramrvg, pgd parampgd, long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Pgd.c() == 3) {
      this.jdField_a_of_type_Rvg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramLong, paramBitmap);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Rvg.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Pgd.c() != 2) || (!ors.a()));
      paramrvg = a(parampgd.a());
    } while ((paramrvg.size() <= 0) || (!paramrvg.contains(Long.valueOf(paramLong))));
    int i = paramrvg.indexOf(Long.valueOf(paramLong));
    this.jdField_a_of_type_Rvg.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(ors.d(this.jdField_a_of_type_Pgd.a()));
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = a(this.jdField_a_of_type_Pgd.a());
        if ((paramView != null) && (paramView.size() == 1))
        {
          paramView = oqu.g + bdfr.encodeToString(String.valueOf(paramView.get(0)).getBytes(), 2);
          ors.a(this.jdField_a_of_type_AndroidContentContext, paramView);
        }
      }
      else
      {
        paramView = b(this.jdField_a_of_type_Pgd.a());
        if (!TextUtils.isEmpty(paramView))
        {
          ors.a(this.jdField_a_of_type_AndroidContentContext, paramView);
          continue;
          if (!this.jdField_a_of_type_Boolean)
          {
            paramView = b(this.jdField_a_of_type_Pgd.a());
            if (!TextUtils.isEmpty(paramView)) {
              ors.a(this.jdField_a_of_type_AndroidContentContext, paramView);
            }
          }
          else
          {
            paramView = a(this.jdField_a_of_type_Pgd.a());
            if (!paramView.isEmpty())
            {
              paramView = oqu.g + bdfr.encodeToString(String.valueOf(paramView.get(0)).getBytes(), 2);
              ors.a(this.jdField_a_of_type_AndroidContentContext, paramView);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pji
 * JD-Core Version:    0.7.0.1
 */