package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.filemanager.app.FileTransferObserver;

class TeamWorkFileImportJobForDisc$1
  extends FileTransferObserver
{
  TeamWorkFileImportJobForDisc$1(TeamWorkFileImportJobForDisc paramTeamWorkFileImportJobForDisc) {}
  
  /* Error */
  public void a(boolean paramBoolean, long paramLong1, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, int paramInt1, java.lang.String paramString4, java.lang.String paramString5, int paramInt2, long paramLong2, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: new 19	org/json/JSONObject
    //   6: dup
    //   7: invokespecial 20	org/json/JSONObject:<init>	()V
    //   10: astore 5
    //   12: iload_1
    //   13: ifeq +459 -> 472
    //   16: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +68 -> 87
    //   22: ldc 28
    //   24: iconst_2
    //   25: new 30	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   32: ldc 33
    //   34: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: lload_2
    //   38: invokevirtual 40	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: ldc 42
    //   43: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload 4
    //   48: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 44
    //   53: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 9
    //   58: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 46
    //   63: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 6
    //   68: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 48
    //   73: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: iload 7
    //   78: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 59	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: new 30	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 61
    //   93: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: astore 4
    //   98: aload 4
    //   100: aload 6
    //   102: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 66
    //   107: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 7
    //   112: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc 68
    //   117: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 8
    //   122: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: new 70	org/json/JSONArray
    //   129: dup
    //   130: invokespecial 71	org/json/JSONArray:<init>	()V
    //   133: astore 6
    //   135: aload 6
    //   137: iconst_0
    //   138: aload 4
    //   140: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokevirtual 75	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   146: pop
    //   147: aload 5
    //   149: ldc 77
    //   151: aload 6
    //   153: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   156: pop
    //   157: aload 5
    //   159: ldc 82
    //   161: aload_0
    //   162: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   165: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   168: getfield 93	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:b	Ljava/lang/String;
    //   171: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   174: pop
    //   175: aload 5
    //   177: ldc 95
    //   179: aload 9
    //   181: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   184: pop
    //   185: iconst_1
    //   186: istore 7
    //   188: iconst_0
    //   189: istore 10
    //   191: aload_0
    //   192: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   195: getfield 98	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   198: ifnull +180 -> 378
    //   201: iload 7
    //   203: ifne +21 -> 224
    //   206: aload 5
    //   208: ldc 82
    //   210: aload_0
    //   211: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   214: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   217: getfield 93	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:b	Ljava/lang/String;
    //   220: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   223: pop
    //   224: aload 5
    //   226: ldc 100
    //   228: iconst_2
    //   229: invokevirtual 103	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload 5
    //   235: ldc 105
    //   237: aload_0
    //   238: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   241: getfield 98	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   244: getfield 110	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   247: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   250: pop
    //   251: aload 5
    //   253: ldc 112
    //   255: aload_0
    //   256: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   259: getfield 98	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   262: getfield 115	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   265: invokestatic 121	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   268: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   271: pop
    //   272: aload 5
    //   274: ldc 123
    //   276: aload_0
    //   277: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   280: getfield 98	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   283: getfield 126	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   286: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   289: pop
    //   290: aload 5
    //   292: ldc 128
    //   294: aload_0
    //   295: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   298: getfield 98	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   301: getfield 131	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileSHA	Ljava/lang/String;
    //   304: invokevirtual 80	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   307: pop
    //   308: aload 5
    //   310: ldc 133
    //   312: aload_0
    //   313: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   316: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   319: getfield 137	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:g	I
    //   322: invokevirtual 103	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload 5
    //   328: ldc 139
    //   330: aload_0
    //   331: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   334: getfield 98	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   337: getfield 143	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   340: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   343: pop
    //   344: iconst_1
    //   345: istore 10
    //   347: aload_0
    //   348: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   351: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   354: aload_0
    //   355: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   358: getfield 98	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   361: getfield 110	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   364: putfield 149	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:l	Ljava/lang/String;
    //   367: aload_0
    //   368: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   371: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   374: iconst_2
    //   375: putfield 151	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:i	I
    //   378: iload 10
    //   380: ifne +8 -> 388
    //   383: iload 7
    //   385: ifeq +179 -> 564
    //   388: aload 5
    //   390: invokestatic 156	com/tencent/mobileqq/teamwork/TeamWorkConvertUtils:a	(Lorg/json/JSONObject;)Z
    //   393: ifeq +171 -> 564
    //   396: aload_0
    //   397: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   400: aload 5
    //   402: invokestatic 159	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:a	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;Lorg/json/JSONObject;)Z
    //   405: ifeq +159 -> 564
    //   408: aload_0
    //   409: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   412: getfield 162	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportHandler	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportHandler;
    //   415: aload 5
    //   417: aload_0
    //   418: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   421: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   424: aload_0
    //   425: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   428: invokevirtual 168	java/lang/Object:hashCode	()I
    //   431: invokevirtual 173	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;I)V
    //   434: return
    //   435: astore 4
    //   437: iconst_0
    //   438: istore 7
    //   440: ldc 28
    //   442: iconst_2
    //   443: new 30	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   450: ldc 175
    //   452: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 4
    //   457: invokevirtual 176	java/lang/Exception:toString	()Ljava/lang/String;
    //   460: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: goto -281 -> 188
    //   472: ldc 28
    //   474: iconst_1
    //   475: new 30	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   482: ldc 33
    //   484: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: lload_2
    //   488: invokevirtual 40	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   491: ldc 181
    //   493: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_0
    //   497: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   500: getfield 87	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   503: getfield 93	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:b	Ljava/lang/String;
    //   506: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc 183
    //   511: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: iload 10
    //   522: istore 7
    //   524: goto -336 -> 188
    //   527: astore 4
    //   529: ldc 28
    //   531: iconst_2
    //   532: new 30	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   539: ldc 185
    //   541: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 4
    //   546: invokevirtual 176	java/lang/Exception:toString	()Ljava/lang/String;
    //   549: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: iconst_0
    //   559: istore 10
    //   561: goto -183 -> 378
    //   564: aload_0
    //   565: getfield 10	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc$1:a	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc;
    //   568: iconst_1
    //   569: invokevirtual 188	com/tencent/mobileqq/teamwork/TeamWorkFileImportJobForDisc:a	(Z)V
    //   572: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	1
    //   0	573	1	paramBoolean	boolean
    //   0	573	2	paramLong1	long
    //   0	573	4	paramString1	java.lang.String
    //   0	573	5	paramString2	java.lang.String
    //   0	573	6	paramString3	java.lang.String
    //   0	573	7	paramInt1	int
    //   0	573	8	paramString4	java.lang.String
    //   0	573	9	paramString5	java.lang.String
    //   0	573	10	paramInt2	int
    //   0	573	11	paramLong2	long
    //   0	573	13	paramBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   126	185	435	java/lang/Exception
    //   191	201	527	java/lang/Exception
    //   206	224	527	java/lang/Exception
    //   224	344	527	java/lang/Exception
    //   347	378	527	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForDisc.1
 * JD-Core Version:    0.7.0.1
 */