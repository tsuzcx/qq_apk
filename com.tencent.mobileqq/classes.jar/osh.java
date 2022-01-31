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

public class osh
  implements View.OnClickListener, ory
{
  private Context jdField_a_of_type_AndroidContentContext;
  private azwg jdField_a_of_type_Azwg;
  private beki jdField_a_of_type_Beki;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private opw jdField_a_of_type_Opw;
  private qoe jdField_a_of_type_Qoe;
  private qtb jdField_a_of_type_Qtb;
  private boolean jdField_a_of_type_Boolean;
  
  public osh(Context paramContext, azwg paramazwg, qoe paramqoe, ListView paramListView, beki parambeki)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Azwg = paramazwg;
    this.jdField_a_of_type_Qoe = paramqoe;
    this.jdField_a_of_type_Beki = parambeki;
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
        Object localObject = obz.a((String)localObject);
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
        JSONObject localJSONObject = obz.a();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", obz.e());
        paramString = "0X800744D";
        if (this.jdField_a_of_type_Opw != null)
        {
          if (rvf.a(this.jdField_a_of_type_Opw.e()))
          {
            paramString = "0X8009357";
            break label92;
          }
        }
        else
        {
          ndn.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
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
  
  private void a(qtb paramqtb, opw paramopw, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      opw localopw = (opw)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131313373);
      qtb localqtb = (qtb)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131313378);
      if ((localopw != null) && (localqtb != null) && (paramopw.a().mGroupId == localopw.a().mGroupId))
      {
        localArrayList1.add(localqtb);
        localArrayList2.add(localopw);
      }
      i += 1;
    }
    paramqtb = new osl(this, paramqtb, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    if (paramInt < localArrayList1.size())
    {
      paramopw = (Animation)((qtb)localArrayList1.get(paramInt)).a().getTag(2131303150);
      if (paramInt != 0) {
        paramopw.setAnimationListener(null);
      }
      for (;;)
      {
        ((qtb)localArrayList1.get(paramInt)).a().startAnimation(paramopw);
        paramInt += 1;
        break;
        paramopw.setAnimationListener(paramqtb);
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
        this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        this.jdField_a_of_type_Qtb.c.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Qtb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (!paramBoolean) {
          break label205;
        }
        i = 8;
        ((KandianUrlImageView)localObject1).setVisibility(i);
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
        localObject1 = this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView;
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
      this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 0);
      break;
      this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      break;
      i = 0;
      break label90;
    }
    label217:
    Object localObject1 = this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {
      if (a(paramArticleInfo).size() == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(i);
      this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramArticleInfo = this.jdField_a_of_type_Qtb.jdField_b_of_type_AndroidWidgetTextView;
      i = k;
      if (paramBoolean) {
        i = 0;
      }
      paramArticleInfo.setVisibility(i);
      this.jdField_a_of_type_Qtb.d.setVisibility(0);
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
  
  public void a(qtb paramqtb, opw paramopw)
  {
    paramqtb = paramopw.a();
    paramopw = a(paramqtb);
    int i = 0;
    if (i < Math.min(4, paramopw.size()))
    {
      if (obz.a()) {
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageDrawable(avwf.a(this.jdField_a_of_type_Azwg, String.valueOf(paramopw.get(i)), 1));
      }
      for (;;)
      {
        String str = String.valueOf(paramopw.get(i));
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setOnClickListener(new osk(this, str, paramqtb));
        i += 1;
        break;
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(this.jdField_a_of_type_Qoe.a(((Long)paramopw.get(i)).longValue()));
      }
    }
    i = Math.min(4, paramopw.size());
    while (i < 4)
    {
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setVisibility(8);
      i += 1;
    }
  }
  
  public void a(qtb paramqtb, opw paramopw, int paramInt)
  {
    this.jdField_a_of_type_Qtb = paramqtb;
    this.jdField_a_of_type_Opw = paramopw;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Opw.a();
    if (this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_Qtb.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Opw.a()) {
        break label179;
      }
    }
    label179:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      if (this.jdField_a_of_type_Opw.a())
      {
        this.jdField_a_of_type_Qtb.a();
        if (this.jdField_a_of_type_Opw.c() != 3) {
          break;
        }
        this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Qtb.f.setVisibility(8);
        if (this.jdField_a_of_type_Qtb.g != null) {
          this.jdField_a_of_type_Qtb.g.setVisibility(8);
        }
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(0);
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setLogic(this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Azwg);
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramopw);
      }
      return;
    }
    this.jdField_a_of_type_Qtb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(8);
    this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidViewView.setVisibility(0);
    switch (this.jdField_a_of_type_Opw.c())
    {
    default: 
      this.jdField_a_of_type_Qtb.d.setOnClickListener(new osi(this, paramopw, paramqtb));
      return;
    case 1: 
      this.jdField_a_of_type_Boolean = false;
      a(false, localArticleInfo);
      localObject = a(localArticleInfo);
      if (localObject == null)
      {
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_Qtb.c.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidWidgetTextView.setText(a(localArticleInfo));
        break;
        obj.a(this.jdField_a_of_type_Qtb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (URL)localObject, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(true, localArticleInfo);
    a(paramqtb, paramopw);
    Object localObject = a(localArticleInfo);
    if (((List)localObject).size() == 1) {
      if (!obz.a()) {
        break label447;
      }
    }
    label447:
    for (localObject = babh.j((QQAppInterface)obz.a(), String.valueOf(((List)localObject).get(0)));; localObject = this.jdField_a_of_type_Qoe.b(((Long)((List)localObject).get(0)).longValue()))
    {
      this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidWidgetTextView.setText(obz.d((String)localObject));
      this.jdField_a_of_type_Qtb.jdField_b_of_type_AndroidWidgetTextView.setText(c(localArticleInfo));
      break;
    }
  }
  
  public void a(qtb paramqtb, opw paramopw, long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Opw.c() == 3) {
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramLong, paramBitmap);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Qtb.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Opw.c() != 2) || (!obz.a()));
      paramqtb = a(paramopw.a());
    } while ((paramqtb.size() <= 0) || (!paramqtb.contains(Long.valueOf(paramLong))));
    int i = paramqtb.indexOf(Long.valueOf(paramLong));
    this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(obz.c(this.jdField_a_of_type_Opw.a()));
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = a(this.jdField_a_of_type_Opw.a());
        if ((paramView != null) && (paramView.size() == 1))
        {
          paramView = obb.g + baaw.encodeToString(String.valueOf(paramView.get(0)).getBytes(), 2);
          obz.a(this.jdField_a_of_type_AndroidContentContext, paramView);
        }
      }
      else
      {
        paramView = b(this.jdField_a_of_type_Opw.a());
        if (!TextUtils.isEmpty(paramView))
        {
          obz.a(this.jdField_a_of_type_AndroidContentContext, paramView);
          continue;
          if (!this.jdField_a_of_type_Boolean)
          {
            paramView = b(this.jdField_a_of_type_Opw.a());
            if (!TextUtils.isEmpty(paramView)) {
              obz.a(this.jdField_a_of_type_AndroidContentContext, paramView);
            }
          }
          else
          {
            paramView = a(this.jdField_a_of_type_Opw.a());
            if (!paramView.isEmpty())
            {
              paramView = obb.g + baaw.encodeToString(String.valueOf(paramView.get(0)).getBytes(), 2);
              obz.a(this.jdField_a_of_type_AndroidContentContext, paramView);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osh
 * JD-Core Version:    0.7.0.1
 */