import android.os.Handler;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class sja
  extends TroopObserver
{
  public sja(EditInfoActivity paramEditInfoActivity) {}
  
  /* Error */
  protected void a(boolean paramBoolean, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: ldc 18
    //   2: istore 7
    //   4: iload_1
    //   5: ifeq +262 -> 267
    //   8: aload_0
    //   9: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   12: getfield 23	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView	Lcom/tencent/mobileqq/troop/widget/EllipsizingTextView;
    //   15: ifnull +228 -> 243
    //   18: aload_2
    //   19: ifnull +224 -> 243
    //   22: aload_2
    //   23: aload_0
    //   24: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   27: getfield 27	com/tencent/mobileqq/activity/EditInfoActivity:f	Ljava/lang/String;
    //   30: invokevirtual 33	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +210 -> 243
    //   36: aload_3
    //   37: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +203 -> 243
    //   43: new 41	android/text/SpannableString
    //   46: dup
    //   47: new 43	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   54: ldc 46
    //   56: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_3
    //   60: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 52
    //   65: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 59	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   74: astore 9
    //   76: ldc 61
    //   78: invokestatic 67	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   81: istore 4
    //   83: ldc 69
    //   85: invokestatic 67	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   88: istore 6
    //   90: iload 4
    //   92: istore 5
    //   94: new 71	sjd
    //   97: dup
    //   98: aload_0
    //   99: iload 5
    //   101: iload 6
    //   103: aload_3
    //   104: invokespecial 74	sjd:<init>	(Lsja;IILjava/lang/String;)V
    //   107: astore 8
    //   109: ldc 46
    //   111: invokevirtual 78	java/lang/String:length	()I
    //   114: istore 4
    //   116: aload_3
    //   117: invokevirtual 78	java/lang/String:length	()I
    //   120: istore 5
    //   122: aload 9
    //   124: aload 8
    //   126: ldc 46
    //   128: invokevirtual 78	java/lang/String:length	()I
    //   131: iload 4
    //   133: iload 5
    //   135: iadd
    //   136: bipush 33
    //   138: invokevirtual 82	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   141: aload_0
    //   142: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   145: getfield 23	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView	Lcom/tencent/mobileqq/troop/widget/EllipsizingTextView;
    //   148: iconst_0
    //   149: invokevirtual 88	com/tencent/mobileqq/troop/widget/EllipsizingTextView:setVisibility	(I)V
    //   152: aload_0
    //   153: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   156: getfield 23	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView	Lcom/tencent/mobileqq/troop/widget/EllipsizingTextView;
    //   159: aload 9
    //   161: invokevirtual 91	com/tencent/mobileqq/troop/widget/EllipsizingTextView:setText	(Ljava/lang/CharSequence;)V
    //   164: aload_0
    //   165: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   168: getfield 23	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView	Lcom/tencent/mobileqq/troop/widget/EllipsizingTextView;
    //   171: new 93	sje
    //   174: dup
    //   175: aload_0
    //   176: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   179: aconst_null
    //   180: invokespecial 96	sje:<init>	(Lcom/tencent/mobileqq/activity/EditInfoActivity;Lsir;)V
    //   183: invokevirtual 100	com/tencent/mobileqq/troop/widget/EllipsizingTextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   186: aload_0
    //   187: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   190: getfield 23	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView	Lcom/tencent/mobileqq/troop/widget/EllipsizingTextView;
    //   193: aload_0
    //   194: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   197: invokevirtual 104	com/tencent/mobileqq/activity/EditInfoActivity:getResources	()Landroid/content/res/Resources;
    //   200: ldc 105
    //   202: invokevirtual 111	android/content/res/Resources:getColor	(I)I
    //   205: invokevirtual 114	com/tencent/mobileqq/troop/widget/EllipsizingTextView:setHighlightColor	(I)V
    //   208: aload_0
    //   209: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   212: getfield 23	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView	Lcom/tencent/mobileqq/troop/widget/EllipsizingTextView;
    //   215: invokevirtual 116	com/tencent/mobileqq/troop/widget/EllipsizingTextView:a	()V
    //   218: aload_0
    //   219: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   222: getfield 23	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView	Lcom/tencent/mobileqq/troop/widget/EllipsizingTextView;
    //   225: bipush 10
    //   227: invokevirtual 119	com/tencent/mobileqq/troop/widget/EllipsizingTextView:setMaxLines	(I)V
    //   230: aload_0
    //   231: getfield 10	sja:a	Lcom/tencent/mobileqq/activity/EditInfoActivity;
    //   234: getfield 23	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView	Lcom/tencent/mobileqq/troop/widget/EllipsizingTextView;
    //   237: getstatic 125	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   240: invokevirtual 129	com/tencent/mobileqq/troop/widget/EllipsizingTextView:setEllipsize	(Landroid/text/TextUtils$TruncateAt;)V
    //   243: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +21 -> 267
    //   249: ldc 137
    //   251: iconst_2
    //   252: iconst_2
    //   253: anewarray 139	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_2
    //   259: aastore
    //   260: dup
    //   261: iconst_1
    //   262: aload_3
    //   263: aastore
    //   264: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   267: return
    //   268: astore 8
    //   270: ldc 18
    //   272: istore 4
    //   274: iload 7
    //   276: istore 6
    //   278: iload 4
    //   280: istore 5
    //   282: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq -191 -> 94
    //   288: ldc 137
    //   290: iconst_2
    //   291: new 43	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   298: ldc 145
    //   300: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 8
    //   305: invokevirtual 146	java/lang/Exception:toString	()Ljava/lang/String;
    //   308: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: iload 7
    //   319: istore 6
    //   321: iload 4
    //   323: istore 5
    //   325: goto -231 -> 94
    //   328: astore 8
    //   330: goto -56 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	sja
    //   0	333	1	paramBoolean	boolean
    //   0	333	2	paramString1	java.lang.String
    //   0	333	3	paramString2	java.lang.String
    //   81	241	4	i	int
    //   92	232	5	j	int
    //   88	232	6	k	int
    //   2	316	7	m	int
    //   107	18	8	localsjd	sjd
    //   268	36	8	localException1	Exception
    //   328	1	8	localException2	Exception
    //   74	86	9	localSpannableString	android.text.SpannableString
    // Exception table:
    //   from	to	target	type
    //   76	83	268	java/lang/Exception
    //   83	90	328	java/lang/Exception
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    this.a.b(false);
    if (paramBoolean) {
      try
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(this.a.e)) {
          return;
        }
        if ((paramObject != null) && (paramObject.memberUin == Long.parseLong(this.a.f)))
        {
          QQToast.a(this.a, 2, 2131433640, 0).b(this.a.getTitleBarHeight());
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new sjc(this, paramObject), 700L);
          return;
        }
      }
      catch (Exception paramObject) {}
    }
  }
  
  protected void c(boolean paramBoolean, ArrayList paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.a.b(false);
      QQToast.a(this.a, 1, 2131433641, 0).b(this.a.getTitleBarHeight());
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new sjb(this), 1500L);
      return;
    }
    paramArrayList = (TroopHandler)this.a.app.a(20);
    try
    {
      paramArrayList.a(Long.parseLong(this.a.e), Long.parseLong(this.a.f));
      return;
    }
    catch (Exception paramArrayList)
    {
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sja
 * JD-Core Version:    0.7.0.1
 */