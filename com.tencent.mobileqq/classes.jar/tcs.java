import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaReply;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.subscribe.comment.MoreCommentPanel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class tcs
  extends BaseAdapter
{
  public static int a;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<stMetaComment> jdField_a_of_type_JavaUtilList;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private yde jdField_a_of_type_Yde;
  private String jdField_b_of_type_JavaLangString = "focus";
  HashSet<Integer> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private String c;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public tcs(Context paramContext, yde paramyde)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      tlo.a("comment", "create mComments ...");
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_Yde = paramyde;
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      return;
      tlo.a("comment", "复用 mComments ...");
    }
  }
  
  public int a(stMetaComment paramstMetaComment)
  {
    if ((paramstMetaComment != null) && (!TextUtils.isEmpty(paramstMetaComment.id)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramstMetaComment.id, Integer.valueOf(3));
      notifyDataSetChanged();
      return 3;
    }
    return -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(int paramInt, stMetaComment paramstMetaComment)
  {
    tlo.d("comment", "addComment ...2");
    if ((paramstMetaComment != null) && (paramInt <= this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramstMetaComment);
    }
  }
  
  public void a(stMetaComment paramstMetaComment)
  {
    Integer localInteger;
    if ((paramstMetaComment != null) && (!TextUtils.isEmpty(paramstMetaComment.id)))
    {
      localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramstMetaComment.id);
      if (localInteger == null) {
        break label66;
      }
    }
    label66:
    for (int i = localInteger.intValue() + 10;; i = 10)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramstMetaComment.id, Integer.valueOf(i));
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null)
    {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
      this.c = paramstSimpleMetaFeed.id;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, stMetaReply paramstMetaReply)
  {
    tlo.d("comment", "addCommentReply :" + paramstMetaReply.wording + ",mComments size:" + this.jdField_a_of_type_JavaUtilList.size());
    if ((!TextUtils.isEmpty(paramString)) && (paramstMetaReply != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        stMetaComment localstMetaComment = (stMetaComment)localIterator.next();
        if (paramString.equals(localstMetaComment.id)) {
          localstMetaComment.replyList.add(0, paramstMetaReply);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    tlo.d("comment", "removeComment ...");
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        if (!paramString.equals(((stMetaComment)this.jdField_a_of_type_JavaUtilList.get(i)).id)) {
          break label95;
        }
        if (this.jdField_a_of_type_JavaUtilList.remove(i) == null) {
          break label90;
        }
      }
      label90:
      for (bool1 = true;; bool1 = false)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        return bool1;
      }
      label95:
      i -= 1;
    }
  }
  
  public boolean a(String paramString, stMetaComment paramstMetaComment)
  {
    boolean bool2 = false;
    tlo.d("comment", "updateComment ...");
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        if (!paramString.equals(((stMetaComment)this.jdField_a_of_type_JavaUtilList.get(i)).id)) {
          break label90;
        }
        if (this.jdField_a_of_type_JavaUtilList.set(i, paramstMetaComment) == null) {
          break label84;
        }
      }
      label84:
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
      label90:
      i -= 1;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    tlo.d("comment", "removeCommentReply ...");
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        stMetaComment localstMetaComment;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localstMetaComment = (stMetaComment)localIterator.next();
        } while (!paramString1.equals(localstMetaComment.id));
        i = localstMetaComment.replyList.size() - 1;
        if (i < 0) {
          break label149;
        }
        if (!paramString2.equals(((stMetaReply)localstMetaComment.replyList.get(i)).id)) {
          break label142;
        }
        if (localstMetaComment.replyList.remove(i) == null) {
          break label136;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      return bool1;
      label136:
      bool1 = false;
      continue;
      label142:
      i -= 1;
      break;
      label149:
      bool1 = false;
    }
  }
  
  public boolean a(String paramString1, String paramString2, stMetaReply paramstMetaReply)
  {
    boolean bool2 = false;
    tlo.d("comment", "updateCommentReply ............. mComments.size:" + this.jdField_a_of_type_JavaUtilList.size());
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramstMetaReply.id))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        stMetaComment localstMetaComment;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          localstMetaComment = (stMetaComment)localIterator.next();
        } while (!paramString1.equals(localstMetaComment.id));
        i = localstMetaComment.replyList.size() - 1;
        if (i < 0) {
          break label184;
        }
        if (!paramString2.equals(((stMetaReply)localstMetaComment.replyList.get(i)).id)) {
          break label175;
        }
        if (localstMetaComment.replyList.set(i, paramstMetaReply) == null) {
          break label169;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      return bool1;
      label169:
      bool1 = false;
      continue;
      label175:
      i -= 1;
      break;
      label184:
      bool1 = false;
    }
  }
  
  public boolean a(Collection<stMetaComment> paramCollection)
  {
    boolean bool = false;
    if (paramCollection != null) {
      bool = this.jdField_a_of_type_JavaUtilList.addAll(paramCollection);
    }
    return bool;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    stMetaComment localstMetaComment = (stMetaComment)getItem(paramInt);
    if (localstMetaComment.isTempData)
    {
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt)))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramInt));
        paramViewGroup = WSPublicAccReport.getTagPositionId(this.jdField_b_of_type_JavaLangString);
        paramView = paramViewGroup;
        if (!paramViewGroup.equals("comment_tag")) {
          paramView = paramViewGroup + jdField_a_of_type_Int;
        }
        WSPublicAccReport.getInstance().reportCommentTagExposure(this.jdField_b_of_type_JavaLangString, paramView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
      }
      for (;;)
      {
        paramView = new MoreCommentPanel(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)paramView.findViewById(2131370715)).setTextColor(-7829368);
        paramView.setOnClickListener(new tct(this, paramInt));
        paramView.setHintText(localstMetaComment.wording);
        return paramView;
        tlo.b("beacon-comment", "重复的position:" + paramInt + ",不上报");
      }
    }
    if (!this.jdField_b_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt)))
    {
      this.jdField_b_of_type_JavaUtilHashSet.add(Integer.valueOf(paramInt));
      localObject = WSPublicAccReport.getPagePositionId(this.jdField_b_of_type_JavaLangString);
      paramViewGroup = (ViewGroup)localObject;
      if (!((String)localObject).equals("comment_page")) {
        paramViewGroup = (String)localObject + jdField_a_of_type_Int;
      }
      WSPublicAccReport.getInstance().reportCommentPageExposure(this.jdField_b_of_type_JavaLangString, paramViewGroup, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if (!(paramView instanceof MoreCommentPanel)) {}
    }
    else
    {
      paramViewGroup = new WsCommentView(this.jdField_a_of_type_AndroidContentContext);
      ((WsCommentView)paramViewGroup).setOnCommentElementClickListener(this.jdField_a_of_type_Yde);
      paramViewGroup.setTag(paramViewGroup);
    }
    paramView = (WsCommentView)paramViewGroup.getTag();
    paramView.setPosition(paramInt);
    paramView.setDisplayNum(3);
    Object localObject = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localstMetaComment.id);
    if (localObject != null) {}
    for (paramInt = ((Integer)localObject).intValue();; paramInt = 3)
    {
      paramView.setData(localstMetaComment, paramInt, this.jdField_a_of_type_JavaLangString);
      return paramViewGroup;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcs
 * JD-Core Version:    0.7.0.1
 */