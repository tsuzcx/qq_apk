import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;

public class ljh
  implements Runnable
{
  public ljh(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, ZhituPicData paramZhituPicData) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	ljh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment	Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;
    //   4: invokestatic 27	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;)Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituManager;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +26 -> 35
    //   12: aload_0
    //   13: getfield 13	ljh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment	Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;
    //   16: invokestatic 30	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;)Z
    //   19: ifeq +16 -> 35
    //   22: aload_1
    //   23: invokevirtual 35	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:c	()V
    //   26: aload_0
    //   27: getfield 13	ljh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment	Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;
    //   30: iconst_0
    //   31: invokestatic 38	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;Z)Z
    //   34: pop
    //   35: new 40	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: getfield 15	ljh:jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData	Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituPicData;
    //   43: getfield 46	com/tencent/mobileqq/activity/aio/zhitu/ZhituPicData:b	Ljava/lang/String;
    //   46: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: invokevirtual 53	java/io/File:toURI	()Ljava/net/URI;
    //   52: invokevirtual 59	java/net/URI:toURL	()Ljava/net/URL;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +113 -> 170
    //   60: aload_1
    //   61: iconst_1
    //   62: invokestatic 65	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Z)Lcom/tencent/image/URLDrawable;
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +25 -> 92
    //   70: aload_0
    //   71: getfield 13	ljh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment	Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;
    //   74: getfield 68	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   77: aload_1
    //   78: invokevirtual 74	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   81: aload_0
    //   82: getfield 13	ljh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment	Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;
    //   85: getfield 77	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   88: iconst_0
    //   89: invokevirtual 83	android/widget/RelativeLayout:setVisibility	(I)V
    //   92: aload_0
    //   93: getfield 13	ljh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment	Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;
    //   96: getfield 86	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText	Lcom/tencent/biz/pubaccount/readinjoy/biu/BiuEditText;
    //   99: ldc 88
    //   101: invokevirtual 94	com/tencent/biz/pubaccount/readinjoy/biu/BiuEditText:setText	(Ljava/lang/CharSequence;)V
    //   104: aload_0
    //   105: getfield 13	ljh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment	Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;
    //   108: invokestatic 97	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;)V
    //   111: aload_0
    //   112: getfield 13	ljh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment	Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;
    //   115: getfield 100	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_a_of_type_Boolean	Z
    //   118: ifeq +24 -> 142
    //   121: aload_0
    //   122: getfield 13	ljh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment	Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;
    //   125: iconst_1
    //   126: invokestatic 102	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;Z)Z
    //   129: pop
    //   130: aload_0
    //   131: getfield 13	ljh:jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment	Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment;
    //   134: getfield 105	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:g	Landroid/widget/ImageView;
    //   137: ldc 106
    //   139: invokevirtual 109	android/widget/ImageView:setImageResource	(I)V
    //   142: return
    //   143: astore_1
    //   144: iconst_0
    //   145: ifeq +25 -> 170
    //   148: aconst_null
    //   149: iconst_1
    //   150: invokestatic 65	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Z)Lcom/tencent/image/URLDrawable;
    //   153: astore_1
    //   154: goto -88 -> 66
    //   157: astore_1
    //   158: iconst_0
    //   159: ifeq +9 -> 168
    //   162: aconst_null
    //   163: iconst_1
    //   164: invokestatic 65	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Z)Lcom/tencent/image/URLDrawable;
    //   167: pop
    //   168: aload_1
    //   169: athrow
    //   170: aconst_null
    //   171: astore_1
    //   172: goto -106 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	ljh
    //   7	71	1	localObject1	Object
    //   143	1	1	localMalformedURLException	java.net.MalformedURLException
    //   153	1	1	localURLDrawable	com.tencent.image.URLDrawable
    //   157	12	1	localObject2	Object
    //   171	1	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	56	143	java/net/MalformedURLException
    //   35	56	157	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljh
 * JD-Core Version:    0.7.0.1
 */