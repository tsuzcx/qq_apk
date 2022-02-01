package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="changed in Okio 2.x")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/-DeprecatedOkio;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "blackhole", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "socket", "Ljava/net/Socket;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k=1, mv={1, 1, 16})
public final class -DeprecatedOkio
{
  public static final -DeprecatedOkio INSTANCE = new -DeprecatedOkio();
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="file.appendingSink()", imports={"okio.appendingSink"}))
  @NotNull
  public final Sink appendingSink(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    return Okio.appendingSink(paramFile);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="blackholeSink()", imports={"okio.blackholeSink"}))
  @NotNull
  public final Sink blackhole()
  {
    return Okio.blackhole();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="sink.buffer()", imports={"okio.buffer"}))
  @NotNull
  public final BufferedSink buffer(@NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    return Okio.buffer(paramSink);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="source.buffer()", imports={"okio.buffer"}))
  @NotNull
  public final BufferedSource buffer(@NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    return Okio.buffer(paramSource);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="file.sink()", imports={"okio.sink"}))
  @NotNull
  public final Sink sink(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    return Okio.sink$default(paramFile, false, 1, null);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="outputStream.sink()", imports={"okio.sink"}))
  @NotNull
  public final Sink sink(@NotNull OutputStream paramOutputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "outputStream");
    return Okio.sink(paramOutputStream);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="socket.sink()", imports={"okio.sink"}))
  @NotNull
  public final Sink sink(@NotNull Socket paramSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "socket");
    return Okio.sink(paramSocket);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="path.sink(*options)", imports={"okio.sink"}))
  @NotNull
  public final Sink sink(@NotNull Path paramPath, @NotNull OpenOption... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramPath, "path");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "options");
    return Okio.sink(paramPath, (OpenOption[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="file.source()", imports={"okio.source"}))
  @NotNull
  public final Source source(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    return Okio.source(paramFile);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="inputStream.source()", imports={"okio.source"}))
  @NotNull
  public final Source source(@NotNull InputStream paramInputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "inputStream");
    return Okio.source(paramInputStream);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="socket.source()", imports={"okio.source"}))
  @NotNull
  public final Source source(@NotNull Socket paramSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "socket");
    return Okio.source(paramSocket);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="path.source(*options)", imports={"okio.source"}))
  @NotNull
  public final Source source(@NotNull Path paramPath, @NotNull OpenOption... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramPath, "path");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "options");
    return Okio.source(paramPath, (OpenOption[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.-DeprecatedOkio
 * JD-Core Version:    0.7.0.1
 */