import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/AuthorCommentDeleteData;", "", "simpleCommentData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "commentType", "", "commentId", "", "subCommentId", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;ILjava/lang/String;Ljava/lang/String;)V", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "getCommentType", "()I", "setCommentType", "(I)V", "getSimpleCommentData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "setSimpleCommentData", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;)V", "getSubCommentId", "setSubCommentId", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class owk
{
  private int jdField_a_of_type_Int;
  @NotNull
  private SimpleCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private String b;
  
  public owk(@NotNull SimpleCommentData paramSimpleCommentData, int paramInt, @NotNull String paramString1, @Nullable String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData = paramSimpleCommentData;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final SimpleCommentData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public String toString()
  {
    return "AuthorCommentDeleteData(simpleCommentData=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData + ", commentType=" + this.jdField_a_of_type_Int + ", commentId='" + this.jdField_a_of_type_JavaLangString + "', subCommentId=" + this.b + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owk
 * JD-Core Version:    0.7.0.1
 */