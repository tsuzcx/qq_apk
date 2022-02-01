package com.tencent.mobileqq.qqexpand.fragment;

import android.text.TextWatcher;
import android.widget.EditText;

class ExtendFriendNewEditFragment$MaxNicknameTextWatcher
  implements TextWatcher
{
  private int b;
  private EditText c;
  private int d;
  private int e;
  
  public ExtendFriendNewEditFragment$MaxNicknameTextWatcher(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment, int paramInt, EditText paramEditText)
  {
    this.b = paramInt;
    this.c = paramEditText;
  }
  
  /* Error */
  public void afterTextChanged(android.text.Editable paramEditable)
  {
    // Byte code:
    //   0: ldc 32
    //   2: astore_1
    //   3: aload_0
    //   4: getfield 25	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:c	Landroid/widget/EditText;
    //   7: invokevirtual 38	android/widget/EditText:getText	()Landroid/text/Editable;
    //   10: invokevirtual 42	java/lang/Object:toString	()Ljava/lang/String;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 48	java/lang/String:getBytes	()[B
    //   18: arraylength
    //   19: aload_0
    //   20: getfield 23	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:b	I
    //   23: if_icmple +335 -> 358
    //   26: aload_0
    //   27: getfield 18	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:a	Lcom/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment;
    //   30: invokestatic 53	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment:b	(Lcom/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment;)Lcom/tencent/mobileqq/widget/QQToast;
    //   33: ifnonnull +23 -> 56
    //   36: aload_0
    //   37: getfield 18	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:a	Lcom/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment;
    //   40: astore_2
    //   41: aload_2
    //   42: aload_2
    //   43: invokestatic 56	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment:c	(Lcom/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment;)Lcom/tencent/mobileqq/app/QBaseActivity;
    //   46: ldc 58
    //   48: iconst_0
    //   49: invokestatic 64	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   52: invokestatic 67	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment:a	(Lcom/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment;Lcom/tencent/mobileqq/widget/QQToast;)Lcom/tencent/mobileqq/widget/QQToast;
    //   55: pop
    //   56: aload_0
    //   57: getfield 18	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:a	Lcom/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment;
    //   60: invokestatic 53	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment:b	(Lcom/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment;)Lcom/tencent/mobileqq/widget/QQToast;
    //   63: invokevirtual 71	com/tencent/mobileqq/widget/QQToast:isShowing	()Z
    //   66: ifne +14 -> 80
    //   69: aload_0
    //   70: getfield 18	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:a	Lcom/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment;
    //   73: invokestatic 53	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment:b	(Lcom/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment;)Lcom/tencent/mobileqq/widget/QQToast;
    //   76: invokevirtual 75	com/tencent/mobileqq/widget/QQToast:show	()Landroid/widget/Toast;
    //   79: pop
    //   80: aload_3
    //   81: iconst_0
    //   82: aload_0
    //   83: getfield 77	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:d	I
    //   86: invokevirtual 81	java/lang/String:substring	(II)Ljava/lang/String;
    //   89: astore 4
    //   91: aload_3
    //   92: aload_0
    //   93: getfield 77	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:d	I
    //   96: aload_0
    //   97: getfield 83	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:e	I
    //   100: iadd
    //   101: aload_3
    //   102: invokevirtual 87	java/lang/String:length	()I
    //   105: invokevirtual 81	java/lang/String:substring	(II)Ljava/lang/String;
    //   108: astore 5
    //   110: aload_3
    //   111: aload_0
    //   112: getfield 77	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:d	I
    //   115: aload_0
    //   116: getfield 77	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:d	I
    //   119: aload_0
    //   120: getfield 83	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:e	I
    //   123: iadd
    //   124: invokevirtual 81	java/lang/String:substring	(II)Ljava/lang/String;
    //   127: astore_2
    //   128: aload_2
    //   129: astore_1
    //   130: aload 4
    //   132: invokevirtual 48	java/lang/String:getBytes	()[B
    //   135: arraylength
    //   136: aload 5
    //   138: invokevirtual 48	java/lang/String:getBytes	()[B
    //   141: arraylength
    //   142: iadd
    //   143: aload_0
    //   144: getfield 23	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:b	I
    //   147: if_icmpgt +211 -> 358
    //   150: aload_2
    //   151: astore_1
    //   152: aload_3
    //   153: invokevirtual 48	java/lang/String:getBytes	()[B
    //   156: arraylength
    //   157: aload_0
    //   158: getfield 23	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:b	I
    //   161: if_icmple +72 -> 233
    //   164: aload_2
    //   165: astore_1
    //   166: aload_2
    //   167: invokevirtual 87	java/lang/String:length	()I
    //   170: ifle +63 -> 233
    //   173: aload_2
    //   174: astore_1
    //   175: aload_2
    //   176: iconst_0
    //   177: aload_2
    //   178: invokevirtual 87	java/lang/String:length	()I
    //   181: iconst_1
    //   182: isub
    //   183: invokevirtual 81	java/lang/String:substring	(II)Ljava/lang/String;
    //   186: astore_2
    //   187: aload_2
    //   188: astore_1
    //   189: new 89	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   196: astore_3
    //   197: aload_2
    //   198: astore_1
    //   199: aload_3
    //   200: aload 4
    //   202: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_2
    //   207: astore_1
    //   208: aload_3
    //   209: aload_2
    //   210: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_2
    //   215: astore_1
    //   216: aload_3
    //   217: aload 5
    //   219: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_2
    //   224: astore_1
    //   225: aload_3
    //   226: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: astore_3
    //   230: goto -80 -> 150
    //   233: aload_2
    //   234: astore_1
    //   235: aload_0
    //   236: getfield 25	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:c	Landroid/widget/EditText;
    //   239: aload_3
    //   240: invokevirtual 99	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
    //   243: aload_2
    //   244: astore_1
    //   245: aload_0
    //   246: getfield 25	com/tencent/mobileqq/qqexpand/fragment/ExtendFriendNewEditFragment$MaxNicknameTextWatcher:c	Landroid/widget/EditText;
    //   249: aload 4
    //   251: invokevirtual 87	java/lang/String:length	()I
    //   254: aload_2
    //   255: invokevirtual 87	java/lang/String:length	()I
    //   258: iadd
    //   259: invokevirtual 103	android/widget/EditText:setSelection	(I)V
    //   262: return
    //   263: astore_2
    //   264: aload 5
    //   266: astore_3
    //   267: goto +18 -> 285
    //   270: astore_2
    //   271: ldc 32
    //   273: astore_3
    //   274: goto +11 -> 285
    //   277: astore_2
    //   278: ldc 32
    //   280: astore 4
    //   282: aload 4
    //   284: astore_3
    //   285: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +70 -> 358
    //   291: new 89	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   298: astore 5
    //   300: aload 5
    //   302: ldc 110
    //   304: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 5
    //   310: aload 4
    //   312: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 5
    //   318: ldc 112
    //   320: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 5
    //   326: aload_3
    //   327: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 5
    //   333: ldc 114
    //   335: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 5
    //   341: aload_1
    //   342: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: ldc 116
    //   348: iconst_2
    //   349: aload 5
    //   351: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: aload_2
    //   355: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	MaxNicknameTextWatcher
    //   0	359	1	paramEditable	android.text.Editable
    //   40	215	2	localObject1	Object
    //   263	1	2	localThrowable1	java.lang.Throwable
    //   270	1	2	localThrowable2	java.lang.Throwable
    //   277	78	2	localThrowable3	java.lang.Throwable
    //   13	314	3	localObject2	Object
    //   89	222	4	str	java.lang.String
    //   108	242	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   110	128	263	java/lang/Throwable
    //   130	150	263	java/lang/Throwable
    //   152	164	263	java/lang/Throwable
    //   166	173	263	java/lang/Throwable
    //   175	187	263	java/lang/Throwable
    //   189	197	263	java/lang/Throwable
    //   199	206	263	java/lang/Throwable
    //   208	214	263	java/lang/Throwable
    //   216	223	263	java/lang/Throwable
    //   225	230	263	java/lang/Throwable
    //   235	243	263	java/lang/Throwable
    //   245	262	263	java/lang/Throwable
    //   91	110	270	java/lang/Throwable
    //   80	91	277	java/lang/Throwable
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt1;
    this.e = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.MaxNicknameTextWatcher
 * JD-Core Version:    0.7.0.1
 */