package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/DualSourceProvider;", "Lshark/StreamingSourceProvider;", "Lshark/RandomAccessSourceProvider;", "shark-hprof"}, k=1, mv={1, 4, 1})
public abstract interface DualSourceProvider
  extends RandomAccessSourceProvider, StreamingSourceProvider
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.DualSourceProvider
 * JD-Core Version:    0.7.0.1
 */