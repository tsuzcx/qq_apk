import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaPerson;
import NS_KING_SOCIALIZE_META.stMetaReply;
import UserGrowth.stCommentJumpText;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class tcu
{
  private static final String jdField_a_of_type_JavaLangString = tcu.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Map<String, ArrayList<stMetaComment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private tdn jdField_a_of_type_Tdn;
  private Map<String, Integer> b = new HashMap();
  private Map<String, tde> c = new HashMap();
  
  public tcu(tdn paramtdn)
  {
    this.jdField_a_of_type_Tdn = paramtdn;
  }
  
  private static ArrayList<stMetaComment> a(stMetaComment[] paramArrayOfstMetaComment)
  {
    paramArrayOfstMetaComment = Arrays.asList(paramArrayOfstMetaComment);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfstMetaComment.size() > 0)
    {
      int i = 0;
      if (i < paramArrayOfstMetaComment.size())
      {
        if (paramArrayOfstMetaComment.get(i) != null)
        {
          localArrayList.add(paramArrayOfstMetaComment.get(i));
          if (i == 0) {
            tlo.c("weishi-comment", "end, comment word:" + ((stMetaComment)paramArrayOfstMetaComment.get(i)).wording + ", id:" + ((stMetaComment)paramArrayOfstMetaComment.get(i)).id);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          tlo.d("weishi-comment", "comment is null");
        }
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = true;
    if (this.c.get(paramString1) == null)
    {
      tde localtde = new tde();
      localtde.jdField_a_of_type_JavaLangString = paramString2;
      if (!paramBoolean1) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        localtde.jdField_a_of_type_Boolean = paramBoolean1;
        this.c.put(paramString1, localtde);
        return;
      }
    }
    paramString1 = (tde)this.c.get(paramString1);
    if (paramString1 != null)
    {
      if (!paramBoolean1) {}
      for (paramBoolean1 = paramBoolean2;; paramBoolean1 = false)
      {
        paramString1.jdField_a_of_type_Boolean = paramBoolean1;
        paramString1.jdField_a_of_type_JavaLangString = paramString2;
        return;
      }
    }
    tlo.d(jdField_a_of_type_JavaLangString, "updateResponseState, commentResponse is null.");
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.c.get(paramString) == null)
    {
      tde localtde = new tde();
      localtde.b = paramBoolean;
      this.c.put(paramString, localtde);
      return;
    }
    paramString = (tde)this.c.get(paramString);
    if (paramString != null)
    {
      paramString.b = paramBoolean;
      return;
    }
    tlo.d(jdField_a_of_type_JavaLangString, "updateResponseState, commentResponse is null.");
  }
  
  private static ArrayList<stMetaComment> b(ArrayList<stMetaComment> paramArrayList, ArrayList<stCommentJumpText> paramArrayList1, int paramInt)
  {
    int m = 0;
    if (paramArrayList.size() == 0) {
      return new ArrayList();
    }
    HashMap localHashMap = new HashMap();
    int i;
    if (paramArrayList1.size() > 0)
    {
      i = 0;
      if (i < paramArrayList1.size())
      {
        stCommentJumpText localstCommentJumpText = (stCommentJumpText)paramArrayList1.get(i);
        stMetaComment localstMetaComment = new stMetaComment();
        localstMetaComment.isTempData = true;
        j = localstCommentJumpText.index;
        localstMetaComment.wording = localstCommentJumpText.text;
        if (j >= paramInt)
        {
          localHashMap.put(Integer.valueOf(j), localstMetaComment);
          label105:
          if (j != -1) {
            break label191;
          }
          tlo.a("comment", localstCommentJumpText.index + ",尾部拉量入口: " + localstMetaComment.wording);
        }
        for (;;)
        {
          i += 1;
          break;
          tlo.a("comment", "oldsize:" + paramInt + ", index:" + j);
          break label105;
          label191:
          tlo.a("comment", localstCommentJumpText.index + ",拉量入口: " + localstMetaComment.wording);
        }
      }
    }
    if ((paramArrayList.size() <= 20) && (localHashMap.containsKey(Integer.valueOf(-1))))
    {
      localHashMap.remove(Integer.valueOf(-1));
      tlo.d("weishi-comment", "评论小于等于20条，移除尾部拉量入口");
    }
    int j = paramArrayList.size() + localHashMap.size();
    tlo.d("weishi-comment", "size1:" + paramArrayList.size() + ",size2:" + localHashMap.size());
    paramArrayList1 = new stMetaComment[j];
    if (localHashMap.keySet().contains(Integer.valueOf(-1)))
    {
      j -= 1;
      paramArrayList1[(paramArrayList1.length - 1)] = ((stMetaComment)localHashMap.get(Integer.valueOf(-1)));
    }
    for (;;)
    {
      int k = 0;
      i = m;
      if (k < j)
      {
        if (localHashMap.keySet().contains(Integer.valueOf(k + paramInt)))
        {
          paramArrayList1[k] = ((stMetaComment)localHashMap.get(Integer.valueOf(k + paramInt)));
          i += 1;
        }
        for (;;)
        {
          k += 1;
          break;
          m = k - i;
          if (m >= paramArrayList.size()) {
            break label463;
          }
          paramArrayList1[k] = ((stMetaComment)paramArrayList.get(m));
        }
        label463:
        tlo.c("weishi-comment", "combineComment end!");
      }
      tlo.d("weishi-comment", "combineComment success");
      return a(paramArrayList1);
    }
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.b.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stMetaComment paramstMetaComment)
  {
    paramstSimpleMetaFeed = new tkj(paramstSimpleMetaFeed.id, paramstMetaComment.id, paramstMetaComment.isDing);
    tgx.a().a(new the(paramstSimpleMetaFeed, a(), new tdb(this, paramstMetaComment), 9));
    return 0L;
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stMetaComment paramstMetaComment, stMetaReply paramstMetaReply)
  {
    tlo.d(jdField_a_of_type_JavaLangString, "reply.poster_id:" + paramstMetaReply.poster.id + ",reply.receiver_id:" + paramstMetaReply.receiver.id + ",reply.beReplyCommendId:" + paramstMetaReply.beReplyReplyId);
    paramstSimpleMetaFeed = new tkk(paramstSimpleMetaFeed, paramstMetaComment, paramstMetaReply);
    tgx.a().a(new the(paramstSimpleMetaFeed, a(), new tcz(this, paramstMetaReply), 6));
    return 0L;
  }
  
  public long a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleComment paramstSimpleComment)
  {
    paramstSimpleMetaFeed = new tkj(paramstSimpleMetaFeed.id, paramstSimpleComment.id, paramstSimpleComment.isDing);
    tgx.a().a(new the(paramstSimpleMetaFeed, a(), new tdc(this, paramstSimpleComment), 9));
    return 0L;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new tcv(this, Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public String a(stSimpleMetaFeed paramstSimpleMetaFeed, stMetaComment paramstMetaComment)
  {
    if ((paramstMetaComment == null) || (paramstMetaComment.id.startsWith("fake_id")))
    {
      umc.a().dispatch(a(new Object[] { Integer.valueOf(5), Integer.valueOf(-1), alud.a(2131702559), null }));
      return "";
    }
    paramstSimpleMetaFeed = new tkd(paramstSimpleMetaFeed.id, paramstMetaComment);
    tgx.a().a(new the(paramstSimpleMetaFeed, a(), new tcy(this, paramstMetaComment), 7));
    return paramstMetaComment.id;
  }
  
  public String a(stSimpleMetaFeed paramstSimpleMetaFeed, stMetaComment paramstMetaComment, stMetaReply paramstMetaReply)
  {
    if ((paramstMetaReply == null) || (paramstMetaReply.id.startsWith("fake_id")))
    {
      umc.a().dispatch(a(new Object[] { Integer.valueOf(6), Integer.valueOf(-1), alud.a(2131702557), null }));
      return "";
    }
    paramstSimpleMetaFeed = new tkd(paramstSimpleMetaFeed.id, paramstMetaComment);
    tgx.a().a(new the(paramstSimpleMetaFeed, a(), new tda(this, paramstMetaComment, paramstMetaReply), 8));
    return paramstMetaReply.id;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (tde)this.c.get(paramString);
    if ((paramString != null) && (paramString.b) && (paramString.jdField_a_of_type_Boolean) && (paramString.jdField_a_of_type_JavaLangString != null)) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public ArrayList<stMetaComment> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public ygc a(Object... paramVarArgs)
  {
    return new ygc(6, paramVarArgs);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stMetaComment paramstMetaComment)
  {
    tlo.d(jdField_a_of_type_JavaLangString, "---添加评论，wording:" + paramstMetaComment.wording + "poster_id:" + paramstMetaComment.poster_id + ",receiver_id:" + paramstMetaComment.receiver_id);
    paramstSimpleMetaFeed = new tkl(paramstSimpleMetaFeed, paramstMetaComment);
    tgx.a().a(new the(paramstSimpleMetaFeed, a(), new tcx(this), 5));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stMetaComment paramstMetaComment, stMetaReply paramstMetaReply)
  {
    paramstSimpleMetaFeed = new tkj(paramstSimpleMetaFeed.id, paramstMetaComment.id, paramstMetaComment.isDing);
    tgx.a().a(new the(paramstSimpleMetaFeed, a(), new tdd(this), 9));
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString, boolean paramBoolean)
  {
    tlo.a(jdField_a_of_type_JavaLangString, "getComments(final stSimpleMetaFeed feed, String attachInfo, final boolean loadMore)");
    paramstSimpleMetaFeed = new the(new tkf(paramString, paramstSimpleMetaFeed.id, 1), a(), new tcw(this, paramstSimpleMetaFeed, paramBoolean), 1000);
    tgx.a().a(paramstSimpleMetaFeed);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    if (paramstSimpleMetaFeed == null)
    {
      tlo.d(jdField_a_of_type_JavaLangString, "getComments , feed is null ");
      return;
    }
    String str = a(paramstSimpleMetaFeed.id);
    tlo.c(jdField_a_of_type_JavaLangString, "getComments loadMore: " + paramBoolean + ", attachInfo:" + str);
    if ((paramBoolean) && (TextUtils.isEmpty(str)))
    {
      tlo.d(jdField_a_of_type_JavaLangString, "getComments and loadMore, attachInfo is empty ");
      return;
    }
    if (!paramBoolean)
    {
      str = "";
      tlo.d(jdField_a_of_type_JavaLangString, "first getComments, set attachInfo empty ");
    }
    a(paramstSimpleMetaFeed.id, false);
    a(paramstSimpleMetaFeed, str, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcu
 * JD-Core Version:    0.7.0.1
 */