import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.ArrayList;
import java.util.List;

public class oif
{
  public int a;
  public SpannableStringBuilder a;
  public BaseCommentData a;
  public ArticleInfo a;
  public CharSequence a;
  public List<SpannableStringBuilder> a;
  public int b;
  public List<CharSequence> b;
  public int c;
  public List<CharSequence> c;
  private int d = 18;
  
  public oif(int paramInt1, int paramInt2, BaseCommentData paramBaseCommentData, ArticleInfo paramArticleInfo)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData = paramBaseCommentData;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_b_of_type_Int = paramInt1;
    a();
  }
  
  public oif(int paramInt, BaseCommentData paramBaseCommentData, ArticleInfo paramArticleInfo)
  {
    this(0, paramInt, paramBaseCommentData, paramArticleInfo);
  }
  
  private CharSequence a(SubCommentData paramSubCommentData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramSubCommentData.hasTarget())
    {
      localSpannableStringBuilder.append("回复 ");
      int i = localSpannableStringBuilder.length();
      if (!TextUtils.isEmpty(paramSubCommentData.repliedUserNickname))
      {
        localSpannableStringBuilder.append(paramSubCommentData.repliedUserNickname);
        localSpannableStringBuilder.setSpan(new oii(this, paramSubCommentData), i, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append("：");
      }
    }
    String str = axau.b(paramSubCommentData.commentContent);
    paramSubCommentData = str;
    if (localSpannableStringBuilder.length() > 0) {
      paramSubCommentData = localSpannableStringBuilder.append(str);
    }
    return paramSubCommentData;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return ajya.a(2131702216);
    }
    return ajya.a(2131702218);
  }
  
  public static void a(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat1, float paramFloat2)
  {
    RectF localRectF = new RectF();
    if ((paramCanvas == null) || (paramPaint == null)) {
      return;
    }
    float f1 = paramInt3 / 2.0F;
    label34:
    float f2;
    label50:
    label85:
    label101:
    float f3;
    if (paramInt4 > 0)
    {
      paramInt3 = paramInt4;
      f2 = paramInt3;
      if (paramInt6 <= 0) {
        break label491;
      }
      paramInt3 = paramInt2 - paramInt6;
      paramCanvas.drawLine(paramFloat1 + f1, paramFloat2 + f2, paramFloat1 + f1, paramFloat2 + paramInt3, paramPaint);
      if (paramInt4 <= 0) {
        break label497;
      }
      paramInt3 = paramInt4;
      f2 = paramInt3;
      if (paramInt5 <= 0) {
        break label503;
      }
      paramInt3 = paramInt1 - paramInt5;
      paramCanvas.drawLine(paramFloat1 + f2, paramFloat2 + f1, paramFloat1 + paramInt3, paramFloat2 + f1, paramPaint);
      f2 = paramInt1;
      if (paramInt5 <= 0) {
        break label509;
      }
      paramInt3 = paramInt5;
      label140:
      f3 = paramInt3;
      float f4 = paramInt1;
      if (paramInt7 <= 0) {
        break label515;
      }
      paramInt3 = paramInt2 - paramInt7;
      label160:
      paramCanvas.drawLine(f2 + paramFloat1 - f1, paramFloat2 + f3, f4 + paramFloat1 - f1, paramFloat2 + paramInt3, paramPaint);
      if (paramInt6 <= 0) {
        break label521;
      }
      paramInt3 = paramInt6;
      label201:
      f2 = paramInt3;
      f3 = paramInt2;
      if (paramInt7 <= 0) {
        break label527;
      }
    }
    label515:
    label521:
    label527:
    for (paramInt3 = paramInt1 - paramInt7;; paramInt3 = paramInt1)
    {
      paramCanvas.drawLine(paramFloat1 + f2, f3 + paramFloat2 - f1, paramFloat1 + paramInt3, paramInt2 + paramFloat2 - f1, paramPaint);
      if (paramInt4 > 0)
      {
        localRectF.set(paramFloat1, paramFloat2, paramInt4 * 2 + paramFloat1, paramInt4 * 2 + paramFloat2);
        localRectF.offset(f1, f1);
        paramCanvas.drawArc(localRectF, 180.0F, 90.0F, false, paramPaint);
      }
      if (paramInt5 > 0)
      {
        localRectF.set(paramInt1 + paramFloat1 - paramInt5 * 2, paramFloat2, paramInt1 + paramFloat1, paramInt5 * 2 + paramFloat2);
        localRectF.offset(-f1, f1);
        paramCanvas.drawArc(localRectF, 270.0F, 90.0F, false, paramPaint);
      }
      if (paramInt7 > 0)
      {
        localRectF.set(paramInt1 + paramFloat1 - paramInt7 * 2, paramInt2 + paramFloat2 - paramInt7 * 2, paramInt1 + paramFloat1, paramInt2 + paramFloat2);
        localRectF.offset(-f1, -f1);
        paramCanvas.drawArc(localRectF, 0.0F, 90.0F, false, paramPaint);
      }
      if (paramInt6 <= 0) {
        break;
      }
      localRectF.set(paramFloat1, paramInt2 + paramFloat2 - paramInt6 * 2, paramInt6 * 2 + paramFloat1, paramInt2 + paramFloat2);
      localRectF.offset(f1, -f1);
      paramCanvas.drawArc(localRectF, 90.0F, 90.0F, false, paramPaint);
      return;
      paramInt3 = 0;
      break label34;
      label491:
      paramInt3 = paramInt2;
      break label50;
      label497:
      paramInt3 = 0;
      break label85;
      label503:
      paramInt3 = paramInt1;
      break label101;
      label509:
      paramInt3 = 0;
      break label140;
      paramInt3 = paramInt2;
      break label160;
      paramInt3 = 0;
      break label201;
    }
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(" ");
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" 作者 ");
    paramSpannableStringBuilder.setSpan(new oik(this, null), i, paramSpannableStringBuilder.length(), 33);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, String paramString3, BaseCommentData paramBaseCommentData)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(paramString1);
    paramSpannableStringBuilder.setSpan(new oij(this, paramBaseCommentData, paramString2, paramString3), i, paramSpannableStringBuilder.length(), 33);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      label26:
      if (this.jdField_b_of_type_JavaUtilList != null) {
        break label490;
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      label44:
      if (this.c != null) {
        break label502;
      }
      this.c = new ArrayList();
      label62:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent)) {
        if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
          break label514;
        }
      }
    }
    List localList;
    int i;
    Object localObject2;
    label514:
    for (this.jdField_a_of_type_JavaLangCharSequence = new aykk(axau.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent), 7, this.d);; this.jdField_a_of_type_JavaLangCharSequence = new aykk(a((SubCommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData), 7, this.d))
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData))
      {
        localList = ((CommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList;
        if ((localList != null) && (localList.size() > 0))
        {
          j = localList.size();
          i = 0;
          if ((i < j) && (i < 2)) {
            break label545;
          }
        }
      }
      if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
        break;
      }
      localList = ((CommentData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList;
      if ((localList == null) || (localList.size() <= 0)) {
        break;
      }
      int j = localList.size();
      i = 0;
      while ((i < j) && ((this.c == null) || (this.c.size() <= 2)))
      {
        localObject1 = (SubCommentData)localList.get(i);
        if ((localObject1 != null) && (((SubCommentData)localObject1).isAuthorReply()))
        {
          localObject2 = new SpannableStringBuilder();
          if (!TextUtils.isEmpty(((SubCommentData)localObject1).nickName))
          {
            a((SpannableStringBuilder)localObject2, ((SubCommentData)localObject1).nickName, ((SubCommentData)localObject1).uin, new ofs(this).a().a(), (BaseCommentData)localObject1);
            a((SpannableStringBuilder)localObject2);
          }
          if (!TextUtils.isEmpty(((SubCommentData)localObject1).repliedUserNickname))
          {
            ((SpannableStringBuilder)localObject2).append(" 回复 ");
            a((SpannableStringBuilder)localObject2, ((SubCommentData)localObject1).repliedUserNickname, ((SubCommentData)localObject1).repliedUserUin, new ofs(this).a().b(((SubCommentData)localObject1).repliedUserUin).a(), (BaseCommentData)localObject1);
          }
          if (!TextUtils.isEmpty(((SubCommentData)localObject1).commentContent))
          {
            ((SpannableStringBuilder)localObject2).append(" : ");
            String str = a(((SubCommentData)localObject1).getCommentMediaType());
            ((SpannableStringBuilder)localObject2).append(new aykk(axau.b(((SubCommentData)localObject1).commentContent) + str, 7, this.d));
            this.c.add(localObject2);
          }
        }
        i += 1;
      }
      break;
      this.jdField_a_of_type_JavaUtilList.clear();
      break label26;
      label490:
      this.jdField_b_of_type_JavaUtilList.clear();
      break label44;
      label502:
      this.c.clear();
      break label62;
    }
    label545:
    Object localObject1 = (SubCommentData)localList.get(i);
    if (localObject1 == null) {}
    for (;;)
    {
      i += 1;
      break;
      localObject2 = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(((SubCommentData)localObject1).nickName))
      {
        ((SpannableStringBuilder)localObject2).append(((SubCommentData)localObject1).nickName);
        ((SpannableStringBuilder)localObject2).setSpan(new oig(this, (SubCommentData)localObject1), 0, ((SpannableStringBuilder)localObject2).length(), 33);
      }
      if ((((SubCommentData)localObject1).hasTarget()) && (!TextUtils.isEmpty(((SubCommentData)localObject1).repliedUserNickname)))
      {
        ((SpannableStringBuilder)localObject2).append(" 回复 ");
        int k = ((SpannableStringBuilder)localObject2).length();
        ((SpannableStringBuilder)localObject2).append(((SubCommentData)localObject1).repliedUserNickname);
        ((SpannableStringBuilder)localObject2).setSpan(new oih(this, (SubCommentData)localObject1), k, ((SpannableStringBuilder)localObject2).length(), 33);
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
      if (!TextUtils.isEmpty(((SubCommentData)localObject1).commentContent))
      {
        localObject2 = a(((SubCommentData)localObject1).getCommentMediaType());
        localObject1 = new aykk(axau.b(((SubCommentData)localObject1).commentContent) + (String)localObject2, 7, this.d);
        this.jdField_b_of_type_JavaUtilList.add(localObject1);
      }
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) || ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oif
 * JD-Core Version:    0.7.0.1
 */